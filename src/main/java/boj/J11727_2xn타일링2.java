package boj;

import java.util.Scanner;

public class J11727_2xn타일링2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1004];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for (int i = 3; i <= 1000; ++i)
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10_007;
        System.out.println(dp[n]);
        sc.close();
    }
}
