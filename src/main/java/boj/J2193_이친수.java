package boj;

import java.util.Scanner;

public class J2193_이친수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[94];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= 90; ++i)
            dp[i] = dp[i - 2] + dp[i - 1];
        System.out.println(dp[n]);
        sc.close();
    }
}
