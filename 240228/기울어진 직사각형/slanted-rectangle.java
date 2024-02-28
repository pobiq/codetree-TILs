import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    static int[][] map;
    static int n, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        result = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }


        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {
        boolean[][] visited = new boolean[n][n];
        int sum = map[i][j];
        visited[i][j] = true;
        int index = 0;

        int x = i;
        int y = j;

        while(true) {

            int xx = x + dx[index];
            int yy = y + dy[index];

            if(xx < 0 || xx >= n || yy < 0 || yy >= n) {
                index++;
                if(index >= 4) break;
                continue;
            }

            if(visited[xx][yy]) break;

            visited[xx][yy] = true;
            sum += map[xx][yy];

            x = xx;
            y = yy;

        }

        if(index == 3) {
            result = Math.max(result, sum);
        }

    }
}