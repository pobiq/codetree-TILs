import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int result = Integer.MAX_VALUE;

    static int[] dist;

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
        dist = new int[1000001];
        Arrays.fill(dist, 1000000);
        bfs(n);

        result = dist[1];

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int a) {
        dist[a] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.number;
            int count = node.count;


            if(count >= n) {
                continue;
            }

            if(number + 1 <= 1000000) {
                if(dist[number+1] > count + 1) {
                    dist[number+1] = count + 1;
                    queue.add(new Node(number+1, count+1));
                }
            }

            if(number - 1 >= 1) {
                if(dist[number-1] > count + 1) {
                    dist[number-1] = count + 1;
                    queue.add(new Node(number-1, count+1));
                }
            }

            if(number % 2 == 0) {
                if(dist[number/2] > count + 1) {
                    dist[number/2] = count + 1;
                    queue.add(new Node(number/2, count+1));
                }
            }

            if(number % 3 == 0) {
                if(dist[number/3] > count + 1) {
                    dist[number/3] = count + 1;
                    queue.add(new Node(number/3, count+1));
                }
            }

        }
    }
}