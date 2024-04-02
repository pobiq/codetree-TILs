import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][n-1] = map[0][n-1];

        for(int j = n-2; j >= 0; j--) {
            dp[0][j] = dp[0][j+1] + map[0][j];
        }

        for(int i = 1; i < n; i++) {
            dp[i][n-1] = dp[i-1][n-1] + map[i][n-1];
        }

        for(int i = 1; i < n; i++) {
            for(int j = n-2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + map[i][j];
            }
        }

        sb.append(dp[n-1][0]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}