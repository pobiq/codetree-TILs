import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;

    static int[][] map;
    static int[][] answer;

    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();


        n = Integer.parseInt(br.readLine());


        map = new int[n][n];
        answer = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    order = 1;
                    count++;
                    dfs(i, j);
                    list.add(order);
                }
            }
        }

        Collections.sort(list);

        sb.append(count).append("\n");
        for(int i : list) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean inRange(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < n) {
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
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY)) {
                order++;
                visited[nextX][nextY] = true;
                dfs(nextX,nextY);
            }
        }
    }
}