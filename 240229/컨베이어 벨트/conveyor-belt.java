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

        int[][] container = new int[2][n];

        for(int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                container[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < t; i++) {
            int[] floor2 = new int[n];
            int[] floor1 = new int[n];

            floor2[0] = container[1][n-1];
            
            for(int j = 1; j < n; j++) {
                floor2[j] = container[0][j-1];
            }

            floor1[0] = container[0][n-1];

            for(int j = 1; j < n; j++) {
                floor1[j] = container[1][j-1];
            }
            container[0] = floor2;
            container[1] = floor1;
        }

        for(int i = 0; i < 2; i++) {
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