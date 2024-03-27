import java.io.*;
import java.util.*;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= n; i++) {
            dp[i] = ((dp[i-1] * 2) % mod + (dp[i-2] * 3 % mod)) % mod;
        }

        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}