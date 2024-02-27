import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        int result = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            int count = 1;
            int number = map[i][0];
            for(int j = 1; j < n; j++) {
                if(number == map[i][j]) {
                    count++;
                } else {
                    number = map[i][j];
                    count = 1;
                }
                if(count >= m) {
                    result++;
                    break;
                }
            }
        }

        for(int j = 0; j < n; j++) {
            int count = 1;
            int number = map[0][j];
            for(int i = 1; i < n; i++) {
                if(number == map[i][j]) {
                    count++;
                } else {
                    number = map[i][j];
                    count = 1;
                }
                if(count >= m) {
                    result++;
                    break;
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}