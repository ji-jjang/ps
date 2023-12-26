package boj;

import java.io.*;

public class J10804_카드역배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[21];
        for (int i = 1; i < 21; i++) {
            num[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            while (a < b) {
                int temp = num[a];
                num[a] = num[b];
                num[b] = temp;
                ++a;
                --b;
            }
        }
        for (int i = 1; i < 21; i++) {
            bw.write(num[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
