import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int n;
    static int r1, c1, r2, c2;
    static int[][] map;
    static boolean[][] visited;

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

        n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], -1);
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st1.nextToken()) - 1;
        c1 = Integer.parseInt(st1.nextToken()) - 1;
        r2 = Integer.parseInt(st1.nextToken()) - 1;
        c2 = Integer.parseInt(st1.nextToken()) - 1;

        visited[r1][c1] = true;
        map[r1][c1] = 0;

        bfs(r1, c1);

        sb.append(map[r2][c2]);
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

            for(int i = 0; i < 8; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[nextX][nextY]) continue;

                map[nextX][nextY] = map[x][y] + 1;
                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));
            }
        }
    }
}