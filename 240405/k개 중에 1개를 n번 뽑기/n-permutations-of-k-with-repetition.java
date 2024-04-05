import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        prev(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prev(int depth) {
        if(depth == n) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= k; i++) {
            list.add(i);
            prev(depth + 1);
            list.remove(new Integer(i));
        }
    }


}