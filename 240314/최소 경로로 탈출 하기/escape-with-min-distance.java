import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[][] step;

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();

        map = new int[n][m];
        visited = new boolean[n][m];
        step = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                step[i][j] = -1;
            }
        }
        step[0][0] = 0;

        bfs(0, 0);

        sb.append(step[n-1][m-1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int a, int b) {
        visited[a][b] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                step[nextX][nextY] = step[x][y] + 1;
                queue.add(new Node(nextX, nextY));

            }
        }
    }
}