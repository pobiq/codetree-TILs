import java.io.*;
import java.util.*;

public class Main {
    static final int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n >= 2) {
            dp[2] = 2;
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}