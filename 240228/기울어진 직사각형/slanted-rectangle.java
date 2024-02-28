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
                for(int a = 1; a <= n-1; a++) {
                    for(int b = 1; b <= n-1; b++) {
                        func(i, j, a, b);
                    }
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void func(int i, int j, int length, int height) {
        int sum = 0;

        int x = i;
        int y = j;

        for(int a = 0; a < length; a++) {
            x += dx[0];
            y += dy[0];

            if(isExist(x, y)) {
                sum += map[x][y];
            } else {
                return;
            }
        }

        for(int a = 0; a < height; a++) {
            x += dx[1];
            y += dy[1];

            if(isExist(x, y)) {
                sum += map[x][y];
            } else {
                return;
            }
        }

        for(int a = 0; a < length; a++) {
            x += dx[2];
            y += dy[2];

            if(isExist(x, y)) {
                sum += map[x][y];
            } else {
                return;
            }
        }

        for(int a = 0; a < height; a++) {
            x += dx[3];
            y += dy[3];

            if(isExist(x, y)) {
                sum += map[x][y];
            } else {
                return;
            }
        }

        result = Math.max(result, sum);

    }

    private static boolean isExist(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
}