import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, h, m;
    static int[][] map;
    static boolean[][] visited;

    static int[][] result;

    static public class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public String toString() {
            return this.x + " " + this.y + " " + this.dist;
        }
    }

    static List<Node> humanList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        StringBuffer sb = new StringBuffer();

        map = new int[n][n];

        result = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                if(map[i][j] == 2) {
                    humanList.add(new Node(i, j, 0));
                }
            }
        }

        for(Node node : humanList) {
            visited = new boolean[n][n];
            bfs(node);
            if(result[node.x][node.y] == 0) {
                result[node.x][node.y] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(Node temp) {
        visited[temp.x][temp.y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            if(map[x][y] == 3) {
                result[temp.x][temp.y] = dist;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextDist = dist + 1;

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[nextX][nextY] || map[nextX][nextY] == 1) continue;

                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY, nextDist));
            }
        }
    }
}