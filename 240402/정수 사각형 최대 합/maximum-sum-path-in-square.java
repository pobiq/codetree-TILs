import java.io.*;
import java.util.*;

public class Main {
    static int mod = 10007;

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

        dp[0][0] = map[0][0];

        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + map[0][j];
        }

        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + map[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }

        sb.append(dp[n-1][n-1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}