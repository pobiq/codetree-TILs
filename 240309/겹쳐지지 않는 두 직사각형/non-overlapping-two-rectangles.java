import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int x1;
        int y1;
        int x2;
        int y2;
        int sum;

        public Node(int x1, int y1, int x2, int y2, int sum) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return x1 + " " + y1 + " " + x2 + " " + y2 + " " + sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = Integer.MIN_VALUE;

        int[][] map = new int[n][m];

        List<Node> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int width = 1; width <= n-i; width++) {
                    for(int height = 1; height <= m-j; height++) {
                        int sum = 0;

                        for(int a = i; a < i + width; a++) {
                            for(int b = j; b < j + height; b++) {
                                sum += map[a][b];
                            }
                        }

                        list.add(new Node(i, j, (i+width-1), (j+height-1), sum));
                    }
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            Loop:
            for(int j = 0; j < list.size(); j++) {
                if(i == j) continue;
                Node node1 = list.get(i);
                Node node2 = list.get(j);


                for(int x = node1.x1; x <= node1.x2; x++) {
                    for(int y = node1.y1; y <= node1.y2; y++) {
                        for(int xx = node2.x1; xx <= node2.x2; xx++) {
                            for(int yy = node2.y1; yy <= node2.y2; yy++) {
                                if(x == xx && y == yy) continue Loop;
                            }
                        }
                    }
                }


                if(result < node1.sum + node2.sum) {
                    result = node1.sum + node2.sum;
                }
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}