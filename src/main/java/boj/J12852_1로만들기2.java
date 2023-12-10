package main.java.boj;

import java.io.*;

public class J12852_1로만들기2 {
    static int[] dp = new int[1_000_001];
    static int[] path = new int[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp[1] = 0; dp[2] = 1; dp[3] = 1;
        path[1] = 1; path[2] = 1; path[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
        }
        bw.write(dp[N] + "\n");
        int now = N;
        while (true) {
            bw.write(now + " ");
            if (now == 1)
                break;
            now = path[now];
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
