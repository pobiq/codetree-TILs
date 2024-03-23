import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k;
    static int r1,c1,r2,c2;
    static int[][] map;
    static boolean[][][] visited;

    static public class Node {
        int x;
        int y;
        int count;
        int dist;

        public Node(int x, int y, int count, int dist) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.dist = dist;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }


    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        StringBuffer sb = new StringBuffer();

        map = new int[n][n];
        visited = new boolean[k+1][n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st2.nextToken()) - 1;
        c1 = Integer.parseInt(st2.nextToken()) - 1;
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st3.nextToken()) - 1;
        c2 = Integer.parseInt(st3.nextToken()) - 1;

        bfs(new Node(r1, c1, 0, 0));

        sb.append(result);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(Node temp) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int count = node.count;
            int dist = node.dist;

            if(x == r2 && y == c2) {
                result = dist;
            }

            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextCount = count + 1;
                int nextDist = dist + 1;

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[count][nextX][nextY]) continue;

                if(map[nextX][nextY] == 1) {
                    if(count < k) {
                        visited[nextCount][nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, nextCount, nextDist));
                    }
                } else {
                    visited[count][nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, count, nextDist));
                }

            }
        }
    }
}