package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J11055_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 4];
        int[] dp = new int[n + 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; ++j) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > mx)
                mx = dp[i];
        }
        System.out.println(mx);
        br.close();
    }
}
