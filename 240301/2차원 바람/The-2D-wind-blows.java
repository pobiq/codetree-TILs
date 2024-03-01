import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            int[][] temp = new int[n][m];

            for(int j = 0; j < map.length; j++) {
                temp[j] = map[j].clone();
            }

            for(int j = c1 + 1; j < c2; j++) {
                temp[r1][j] = map[r1][j-1];
                temp[r2][j] = map[r2][j+1];
            }

            for(int j = r1; j <= r2; j++) {
                if(j == r2) {
                    temp[j][c1] = map[j][c1+1];
                } else {
                    temp[j][c1] = map[j+1][c1];
                }
            }

            for(int j = r1; j <= r2; j++) {
                if(j == r1) {
                    temp[j][c2] = map[j][c2-1];
                } else {
                    temp[j][c2] = map[j-1][c2];
                }
            }

            for(int j = 0; j < map.length; j++) {
                map[j] = temp[j].clone();
            }

            for(int a = r1; a <= r2; a++) {
                for(int b = c1; b <= c2; b++) {
                    int sum = map[a][b];
                    int count = 1;

                    if(a-1 >= 0) {
                        count++;
                        sum += map[a-1][b];
                    }

                    if(a+1 < n) {
                        count++;
                        sum += map[a+1][b];
                    }

                    if(b-1 >= 0) {
                        count++;
                        sum += map[a][b-1];
                    }

                    if(b+1 < m) {
                        count++;
                        sum += map[a][b+1];
                    }

                    temp[a][b] = sum / count;
                }
            }

            for(int j = 0; j < map.length; j++) {
                map[j] = temp[j].clone();
            }

        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}