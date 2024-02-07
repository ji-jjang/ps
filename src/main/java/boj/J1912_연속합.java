package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100_004];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + num, num);
        }
        int mx = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > mx)
                mx = dp[i];
        }
        System.out.println(mx);
        br.close();
    }
}
