class Solution {
    public int solution(String s) {
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
        int ans = 1;

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans = 2;
            }
        }

        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i < n - len + 1; ++i) {
                int j = i + len - 1;
                
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    ans = len;
                }
            }
        }

        return ans;
    }
}