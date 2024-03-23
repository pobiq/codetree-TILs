import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int result = Integer.MAX_VALUE;

    static boolean[][] visited;

    static public class Node {
        int number;
        int count;

        public Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1][1000001];
        bfs(n);

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int a) {
        visited[0][a] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.number;
            int count = node.count;

            if(number == 1) {
                result = Math.min(result, count);
            }

            if(count >= n) {
                continue;
            }

            if(number + 1 <= 1000000) {
                if(!visited[count+1][number+1]) {
                    visited[count+1][number+1] = true;
                    queue.add(new Node(number+1, count+1));
                }
            }

            if(number - 1 >= 1) {
                if(!visited[count+1][number-1]) {
                    visited[count+1][number-1] = true;
                    queue.add(new Node(number-1, count+1));
                }
            }

            if(number % 2 == 0) {
                if(!visited[count+1][number/2]) {
                    visited[count+1][number/2] = true;
                    queue.add(new Node(number/2, count+1));
                }
            }

            if(number % 3 == 0) {
                if(!visited[count+1][number/3]) {
                    visited[count+1][number/3] = true;
                    queue.add(new Node(number/3, count+1));
                }
            }

        }
    }
}