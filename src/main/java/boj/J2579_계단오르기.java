package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2579_계단오르기 {
    static int[][] dp = new int[301][3];
    static int[] step = new int[301];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        dp[1][1] = step[1]; dp[1][2] = 0; dp[2][1] = step[2]; dp[2][2] = step[1] + step[2];
        for (int i = 3; i <= N; ++i) {
            dp[i][1] = Math.max(dp[i - 2][2], dp[i - 2][1]) + step[i];
            dp[i][2] = dp[i - 1][1] + step[i];
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}
