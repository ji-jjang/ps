class Solution {
    public int solution(int n) {
        
        long[] dp = new long[n + 1];
        int MOD = 1_000_000_007;
        
        if (n % 2 != 0)
            return 0;
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= MOD;
        }
        return (int)dp[n];
    }
}