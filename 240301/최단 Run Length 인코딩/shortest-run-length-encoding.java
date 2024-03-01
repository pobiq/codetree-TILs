import java.io.*;
import java.util.*;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String str = br.readLine();

        int n = str.length();

        for(int i = 0; i < n; i++) {
            str = str.substring(str.length()-1) + str.substring(0, str.length()-1);
            RunLengthEncoding(str);
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void RunLengthEncoding(String str) {
        char text = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for(int i = 1; i < str.length(); i++) {
            if(text == str.charAt(i)) {
                count++;
            } else {
                sb.append(text);
                sb.append(count);
                count = 1;
                text = str.charAt(i);
            }
        }

        sb.append(text);
        sb.append(count);

        answer = Math.min(answer, sb.length());
    }
}