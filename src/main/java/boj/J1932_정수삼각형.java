package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; ++j) {
                int num = Integer.parseInt(st.nextToken());
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + num;
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; ++i) {
            if (dp[n][i] > mx)
                mx = dp[n][i];
        }
        System.out.println(mx);
        br.close();
    }
}
