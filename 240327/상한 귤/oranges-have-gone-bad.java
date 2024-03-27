import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> badOrangeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    badOrangeList.add(new Node(i, j));
                    visited[i][j] = true;
                }
                if(map[i][j] == 0) {
                    result[i][j] = -1;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();

        for(Node node : badOrangeList) {
            queue.add(node);
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for(int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if(xx < 0 || xx >= n || yy < 0 || yy >= n) continue;

                if(visited[xx][yy] || map[xx][yy] == 0) continue;

                visited[xx][yy] = true;
                result[xx][yy] = result[x][y] + 1;
                queue.add(new Node(xx, yy));
            }

        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    result[i][j] = -2;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}