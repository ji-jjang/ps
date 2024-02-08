package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 4];
        int[] p = new int[n + 4];
        int[] dp = new int[n + 4];
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; ++i) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + t[i] <= n + 1)
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
        }
        System.out.println(Math.max(dp[n], dp[n + 1]));
        br.close();
    }
}
