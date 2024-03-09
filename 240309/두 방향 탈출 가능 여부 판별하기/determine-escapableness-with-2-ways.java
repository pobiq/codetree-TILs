import java.io.*;
import java.util.*;

public class Main {
    static int order = 1;
    static boolean[][] visited;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int n, m;

    static int[][] map;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int result = Integer.MIN_VALUE;

        map = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer[0][0] = order;
        visited[0][0] = true;
        dfs(0, 0);

        result = answer[n-1][m-1];

        sb.append(result);
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
        if(map[x][y] == 0 || visited[x][y]) {
            return false;
        }
        return true;
    }

    public static void dfs(int x, int y) {
        for(int i = 0; i < 2; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY)) {
                answer[nextX][nextY] = order;
                visited[nextX][nextY] = true;
                dfs(nextX,nextY);
            }
        }
    }
}