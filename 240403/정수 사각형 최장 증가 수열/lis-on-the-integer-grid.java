import java.io.*;
import java.util.*;

class Cell implements Comparable<Cell> {
    int num, x, y;

    public Cell(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Cell c) {
        return this.num - c.num;      // num 기준으로 오름차순 정렬합니다.
    }
}

public class Main {
    static int n;

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        int result = 0;

        int[][] dp = new int[500][500];
        int[][] map = new int[500][500];

        ArrayList<Cell> cells = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1;
                cells.add(new Cell(map[i][j], i, j));
            }
        }

        Collections.sort(cells);

        for(int i = 0; i < cells.size(); i++) {
            int x = cells.get(i).x;
            int y = cells.get(i).y;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(inRange(nx, ny) && map[nx][ny] > map[x][y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}