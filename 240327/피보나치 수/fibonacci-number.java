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

        int result = fibo(n);

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int fibo(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        if(n <= 2) {
            return 1;
        } else {
            dp[n] = fibo(n - 1) + fibo(n - 2);
        }

        return dp[n];

    }
}