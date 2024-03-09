import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, k;
    static int[][] map;
    static boolean[][] visited;

    static int max = -1;


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
        visited = new boolean[n][n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken()) - 1;
        int c = Integer.parseInt(st2.nextToken()) - 1;

        int nextR = r;
        int nextC = c;

        int prevR = 0;
        int prevC = 0;

        for(int i = 0; i < k; i++) {
            visited = new boolean[n][n];
            max = -1;
            ArrayList<int[]> list = new ArrayList<>();
            bfs(nextR, nextC, list);

            if(list.isEmpty()) {
                break;
            }

            prevR = 0;
            prevC = 0;

            for(int j = 0; j < list.size(); j++) {
                int[] temp = list.get(j);
                if(max == temp[2]) {
                    if(prevR == 0 && prevC == 0) {
                        prevR = temp[0];
                        prevC = temp[1];
                    } else {
                      if(prevR > temp[0]) {
                          prevR = temp[0];
                          prevC = temp[1];
                      } else if(prevR == temp[0]) {
                          if(prevC > temp[1]) {
                              prevC = temp[1];
                          }
                      }
                    }
                }
            }

            nextR = prevR;
            nextC = prevC;
        }


        sb.append((nextR + 1) + " " + (nextC + 1));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, ArrayList<int[]> list) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int a = 0; a < 4; a++) {
                int nextX = temp[0] + dx[a];
                int nextY = temp[1] + dy[a];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;

                if(visited[nextX][nextY] || map[nextX][nextY] >= map[x][y]) continue;
                if(max < map[nextX][nextY]) {
                    max = map[nextX][nextY];
                }
                list.add(new int[]{nextX, nextY, map[nextX][nextY]});
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
            }
        }
    }
}