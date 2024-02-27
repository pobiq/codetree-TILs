import java.io.*;
import java.util.*;

public class Main {

    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a = 0; a < n; a++) {
            for(int b = 0; b < n; b++) {
                for(int k = 0; k <= n; k++) {
                    boolean[][] vistied = new boolean[n][n];
                    bfs(a, b, k, vistied);
                }

            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int a, int b, int k, boolean[][] vistied) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 0});
        vistied[a][b] = true;
        int countCoin = 0;
        if(map[a][b] == 1) {
            countCoin = 1;
        }

        QUEUE:
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int length = temp[2];

            for(int i=0; i<4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                int llength = length + 1;

                if(llength > k) break QUEUE;

                if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;

                if(vistied[xx][yy]) continue;

                if(map[xx][yy] == 1) countCoin++;
                vistied[xx][yy] = true;
                queue.add(new int[]{xx,yy,llength});
            }
        }

        int area = k * k + (k+1) * (k+1);
        int totalGold = m * countCoin;

        if(area <= totalGold) {
            result = Math.max(result, countCoin);
        }
    }
}