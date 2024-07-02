import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static final int BLANK = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st1.nextToken()) - 1;
        int y = Integer.parseInt(st1.nextToken()) - 1;

        int length = map[x][y] - 1;

        map[x][y] = BLANK;
        for(int i = 1; i <= length; i++) {
            for(int j = 0; j < 4; j++) {
                int nextX = x + dx[j] * i;
                int nextY = y + dy[j] * i;

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                map[nextX][nextY] = BLANK;
            }
        }

        for(int j = 0; j < n; j++) {
            int[] temp = new int[n];
            int index = 0;
            for(int i = n-1; i >= 0; i--) {
                if(map[i][j] != BLANK) {
                    temp[index++] = map[i][j];
                }
            }

            for(int i = n-1; i >= 0; i--) {
                map[i][j] = temp[n-1-i];
            }

        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}