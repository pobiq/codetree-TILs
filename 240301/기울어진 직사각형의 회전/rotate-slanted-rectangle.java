import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();


        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        int[][] temp = new int[n][n];

        for(int j = 0; j < map.length; j++) {
            temp[j] = map[j].clone();
        }

        if(dir == 0) {
            // 반시계 방향
            for(int i = 0; i < m1; i++) {
                temp[--r][++c] = map[r+1][c-1];
            }
            for(int i = 0; i < m2; i++) {
                temp[--r][--c] = map[r+1][c+1];
            }
            for(int i = 0; i < m3; i++) {
                temp[++r][--c] = map[r-1][c+1];
            }
            for(int i = 0; i < m4; i++) {
                temp[++r][++c] = map[r-1][c-1];
            }
        } else {
            // 시계 방향
            for(int i = 0; i < m1; i++) {
                if(i == m1-1) {
                    temp[--r][++c] = map[r-1][c-1];
                } else {
                    temp[--r][++c] = map[r-1][c+1];
                }
            }
            for(int i = 0; i < m2; i++) {
                if(i == m2-1) {
                    temp[--r][--c] = map[r+1][c-1];
                } else {
                    temp[--r][--c] = map[r-1][c-1];
                }
            }
            for(int i = 0; i < m3; i++) {
                if(i == m3-1) {
                    temp[++r][--c] = map[r+1][c+1];
                } else {
                    temp[++r][--c] = map[r+1][c-1];
                }
            }
            for(int i = 0; i < m4; i++) {
                if(i == m4-1) {
                    temp[++r][++c] = map[r-1][c+1];
                } else {
                    temp[++r][++c] = map[r+1][c+1];
                }
            }
        }

        for(int j = 0; j < map.length; j++) {
            map[j] = temp[j].clone();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}