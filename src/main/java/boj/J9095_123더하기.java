package main.java.boj;

import java.io.*;

public class J9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
