import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;

    static int[][] map;

    static int blockMax = 0;
    static int blockCount = 0;

    static int block = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    int number = map[i][j];
                    block = 0;
                    dfs(i, j, number);
                    if(block >= 4) {
                        blockCount++;
                    }
                    if(blockMax < block) {
                        blockMax = block;
                    }
                }
            }
        }

        sb.append(blockCount + " " + blockMax);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean inRange(int x, int y) {
        if(0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }
        return false;
    }

    public static boolean canGo(int x, int y, int number) {
        if(!inRange(x, y)) {
            return false;
        }
        if(visited[x][y]) {
            return false;
        }
        if(map[x][y] != number) {
            return false;
        }
        return true;
    }

    public static void dfs(int x, int y, int number) {
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(canGo(nextX, nextY, number)) {
                block++;
                visited[nextX][nextY] = true;
                dfs(nextX,nextY,number);
            }
        }
    }
}