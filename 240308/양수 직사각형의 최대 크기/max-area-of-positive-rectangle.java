import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = -1;

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int width = 1; width <= n-i; width++) {
                    for(int height = 1; height <= m-j; height++) {
                        boolean flag = true;

                        Loop:
                        for(int a = i; a < i + width; a++) {
                            for(int b = j; b < j + height; b++) {
                                if(map[a][b] <= 0) {
                                    flag = false;
                                    break Loop;
                                }
                            }
                        }

                        if(flag) {
                            result = Math.max(result, width * height);
                        }
                    }
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}