import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k, u, d;
    static int[][] map;
    static boolean[][] visited;

    static int result;

    static StringBuffer sb = new StringBuffer();
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

    static List<Node> buildList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][n];


        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                buildList.add(new Node(i, j));
            }
        }

        combination(buildList, new Node[k], 0, 0);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(List<Node> buildList, Node[] output, int depth, int start) {
        if(depth == k) {
            visited = new boolean[n][n];

            for(Node node : output) {
                bfs(node.x, node.y, map[node.x][node.y]);
            }

            int count = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) {
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
            return;
        }

        for(int i = start; i < buildList.size(); i++) {
            output[depth] = buildList.get(i);
            combination(buildList, output, depth + 1, start + 1);
        }
    }

    private static void bfs(int x, int y, int value) {
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int a = 0; a < 4; a++) {
                int nextX = node.x + dx[a];
                int nextY = node.y + dy[a];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[nextX][nextY]) continue;

                if(Math.abs(map[nextX][nextY] - map[node.x][node.y]) < u) continue;
                if(Math.abs(map[nextX][nextY] - map[node.x][node.y]) > d) continue;

                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY));

            }
        }
    }
}