import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] container = new int[3][n];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                container[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < t; i++) {
            int[] container1 = new int[n];
            container1[0] = container[2][n-1];
            for(int j = 1; j < n; j++) {
                container1[j] = container[0][j-1];
            }
            int[] container2 = new int[n];
            container2[0] = container[0][n-1];
            for(int j = 1; j < n; j++) {
                container2[j] = container[1][j-1];
            }
            int[] container3 = new int[n];
            container3[0] = container[1][n-1];
            for(int j = 1; j < n; j++) {
                container3[j] = container[2][j-1];
            }
            container[0] = container1;
            container[1] = container2;
            container[2] = container3;
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(container[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}