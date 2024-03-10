import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k, m;
    static int[][] map;
    static int[][] brokenMap;
    static boolean[][] visited;

    static int result = -1;

    static StringBuffer sb = new StringBuffer();
    static public class Node {

        int count;
        int x;
        int y;


        public Node(int count, int x, int y) {
            this.count = count;
            this.x = x;
            this.y = y;
        }
    }

    static public class Edge {
        int x;
        int y;

        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static ArrayList<Edge> list = new ArrayList<>();
    static ArrayList<Edge> cooList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        brokenMap = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
                if(map[i][j] == 1) {
                    list.add(new Edge(i, j));
                }
            }
        }

        for(int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken()) - 1;
            int c = Integer.parseInt(st2.nextToken()) - 1;
            cooList.add(new Edge(r, c));
        }

        combination(list, new Edge[m], 0, 0);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(ArrayList<Edge> list, Edge[] output, int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < n; i++) {
                brokenMap[i] = map[i].clone();
            }

            for(Edge e : output) {
                brokenMap[e.x][e.y] = 0;
            }

            visited = new boolean[n][n];

            for(Edge e : cooList) {
                bfs(e.x, e.y);
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

        for(int i = start; i < list.size(); i++) {
            output[depth] = list.get(i);
            combination(list, output, depth + 1, start + 1);
        }
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int a = 0; a < 4; a++) {
                int nextCount = node.count + 1;
                int nextX = node.x + dx[a];
                int nextY = node.y + dy[a];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[nextX][nextY] || brokenMap[nextX][nextY] == 1) continue;

                visited[nextX][nextY] = true;
                queue.add(new Node(nextCount, nextX, nextY));

            }
        }
    }
}