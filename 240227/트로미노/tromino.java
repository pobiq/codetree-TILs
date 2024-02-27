import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // case 1-1
                if(i+1 < n && j+1 < m) {
                    result = Math.max(result, cal(map[i][j], map[i+1][j], map[i+1][j+1]));
                }

                // case 1-2
                if(i+1 < n && j-1 >= 0) {
                    result = Math.max(result, cal(map[i][j], map[i+1][j-1], map[i+1][j-1]));
                }

                // case 1-3
                if(i+1 < n && j-1 >= 0) {
                    result = Math.max(result, cal(map[i][j], map[i][j-1], map[i+1][j]));
                }

                // case 1-4
                if(i+1 < n && j+1 < m) {
                    result = Math.max(result, cal(map[i][j], map[i][j+1], map[i+1][j]));
                }

                // case 2-1
                if(j+2 < m) {
                    result = Math.max(result, cal(map[i][j], map[i][j+1], map[i][j+2]));
                }

                // case 2-2
                if(j-2 >= 0) {
                    result = Math.max(result, cal(map[i][j], map[i][j-1], map[i][j-2]));
                }
            }
        }


        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int cal(int a, int b, int c) {
        return a + b + c;
    }
}