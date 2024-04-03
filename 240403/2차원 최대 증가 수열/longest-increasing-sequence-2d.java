import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        int result = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for(int a = i+1; a < n; a++) {
                    for(int b = j+1; b < m; b++) {
                        if(map[a][b] > map[i][j]) {
                            dp[a][b] = Math.max(dp[a][b], dp[i][j] + 1);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}