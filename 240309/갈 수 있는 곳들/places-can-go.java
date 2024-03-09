import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k;
    static int result = 0;
    static int[][] map;
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        visited = new boolean[k][n][n];

        for(int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken()) - 1;
            int c = Integer.parseInt(st2.nextToken()) - 1;
            bfs(i, r, c);
        }
        
        
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < n; b++) {
                boolean flag = true;
                for(int i = 0; i < k; i++) {
                    if (!visited[i][a][b]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result++;
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int x, int y) {
        visited[i][x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, x, y});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int a = 0; a < 4; a++) {
                int nextX = temp[1] + dx[a];
                int nextY = temp[2] + dy[a];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[i][nextX][nextY] || map[nextX][nextY] == 1) continue;

                visited[i][nextX][nextY] = true;

                queue.add(new int[]{i, nextX, nextY});

            }
        }
    }
}