import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=n-3; j++) {
                int count = 0;
                for(int a=i; a<i+3; a++) {
                    for(int b=j; b<j+3; b++) {
                        if(map[a][b] == 1) {
                            count++;
                        }
                    }
                }
                answer = Math.max(answer, count);
            }
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}