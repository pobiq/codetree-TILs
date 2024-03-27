import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        if(n >= 2) {
            dp[2] = 1;
        }
        if(n >= 3) {
            dp[3] = 1;
        }

        int result = recursion(n);

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int recursion(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        if(n <= 3) {
            return dp[n];
        } else {
            dp[n] = recursion(n - 2) + recursion(n - 3);
        }

        return dp[n];
    }
}