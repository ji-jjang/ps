package boj;

import java.util.Scanner;

public class J10844_쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n + 4][14];
        for (int i = 0; i < 9; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j <= 8; ++j)
                dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % 1_000_000_000;
        }
        long ans = 0;
        for (int j = 0; j < 10; ++j)
            ans += dp[n][j];
        System.out.println(ans % 1_000_000_000);
        sc.close();
    }
}
