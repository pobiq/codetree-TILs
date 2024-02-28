import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while(!stack.isEmpty()) {
            int number = stack.pop();
            for(int i = 0; i < n; i++) {
                if(map[number][i] == 1) {
                    int next = i;
                    if(!visited[next]) {
                        visited[next] = true;
                        stack.add(next);
                        result++;
                    }
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}