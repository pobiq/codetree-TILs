import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        int[] map = new int[n];
        int[] dp = new int[n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == Integer.MIN_VALUE) {
                    continue;
                }

                if(map[j] + j >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}