import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> l = new ArrayList<>();
        while (k > 1) {
            l.add(k);
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
        }
        l.add(1);
        
        int n = l.size();
        double[] dp = new double[n];
        for (int i = 1; i < n; ++i) {
            dp[i] = (l.get(i - 1) + l.get(i)) / 2.0;
        }
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i] + dp[i - 1];
        }
        
        double[] ans = new double[ranges.length];
        for (int i = 0; i < ranges.length; ++i) {
            int st = ranges[i][0];
            int en = n + ranges[i][1] - 1;
            if (st <= en) ans[i] = dp[en] - dp[st];
            else ans[i] = -1.0;
        }
        
        return ans;
    }
}