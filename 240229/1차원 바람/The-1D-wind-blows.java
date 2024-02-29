import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();


            int[] temp = new int[m];
            wind(map, temp, number, dir);
            
            map[number] = temp;

            String tempDir = dir;
            int tempNumber = number;

            while(true) {
                if(tempNumber == 0) {
                    break;
                }
                for(int j = 0; j < m; j++) {
                    if(map[tempNumber][j] == map[tempNumber-1][j]) {
                        int[] temp1 = new int[m];
                        tempDir = tempDir.equals("L") ? "R" : "L";
                        wind(map, temp1, tempNumber-1, tempDir);
                        map[tempNumber-1] = temp1;
                        break;
                    }
                }
                tempNumber--;
            }

            tempNumber = number;
            tempDir = dir;

            while(true) {
                if(tempNumber == n-1) {
                    break;
                }
                for(int j = 0; j < m; j++) {
                    if(map[tempNumber][j] == map[tempNumber+1][j]) {
                        int[] temp1 = new int[m];
                        tempDir = tempDir.equals("L") ? "R" : "L";
                        wind(map, temp1, tempNumber+1, tempDir);
                        map[tempNumber+1] = temp1;
                        break;
                    }
                }
                tempNumber++;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void wind(int[][] map, int[] temp, int number, String dir) {
        int m = map[0].length;
        if(dir.equals("L")) {
            temp[0] = map[number][m-1];
            for(int j = 1; j < m; j++) {
                temp[j] = map[number][j-1];
            }
        } else {
            temp[m-1] = map[number][0];
            for(int j = m-2; j >= 0; j--) {
                temp[j] = map[number][j+1];
            }
        }
    }
    
}