package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        int[] r = new int[N + 1];
        int[] g = new int[N + 1];
        int[] b = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            String[] costs = br.readLine().split(" ");
            r[i] = Integer.parseInt(costs[0]);
            g[i] = Integer.parseInt(costs[1]);
            b[i] = Integer.parseInt(costs[2]);
        }
        dp[1][0] = r[1]; dp[1][1] = g[1]; dp[1][2] = b[1];
        for (int i = 2; i <= N; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b[i];
        }
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
