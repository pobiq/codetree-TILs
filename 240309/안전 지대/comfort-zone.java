import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    static int[][] map;
    static int rain_max = 0;

    static int K_max = 0;
    static int count_max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                rain_max = Math.max(rain_max, map[i][j]);
            }
        }

        for(int K = 1; K <= rain_max; K++) {
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] <= K) {
                        visited[i][j] = true;
                    }
                }
            }
            int count = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        count++;
                        dfs(i, j);
                    }
                }
            }

            if(count_max < count) {
                count_max = count;
                K_max = K;
            }

        }


        sb.append(K_max + " " + count_max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean inRange(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < m) {
            return true;
        }
        return false;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) {
            return false;
        }
        if(visited[x][y]) {
            return false;
        }
        return true;
    }

    public static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY)) {
                visited[nextX][nextY] = true;
                dfs(nextX,nextY);
            }
        }
    }
}