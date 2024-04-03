import java.io.*;
import java.util.*;


public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        int result = 0;

        int[][] dp = new int[100][100];
        int[][] map = new int[100][100];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        for(int j = 1; j < n; j++) {
            dp[0][j] = Math.max(map[0][j], dp[0][j-1]);
        }

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(map[i][0], dp[i-1][0]);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(Math.max(dp[i-1][j], map[i][j]), Math.max(dp[i][j-1], map[i][j]));
            }
        }

        sb.append(dp[n-1][n-1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}