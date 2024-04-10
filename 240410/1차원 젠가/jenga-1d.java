import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        n = Integer.parseInt(br.readLine());

        int[] block = new int[n];

        for(int i = 0; i < n; i++) {
            block[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            int[] temp = new int[block.length];

            int endOfTempArray = 0;

            for(int a = 0; a < block.length; a++) {
                if(a < left || right < a) {
                    temp[endOfTempArray++] = block[a];
                }
            }

            block = new int[endOfTempArray];

            for(int a = 0; a < endOfTempArray; a++) {
                block[a] = temp[a];
            }
        }

        sb.append(block.length).append("\n");

        for(int i : block) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}