import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        List<int[]> times = new ArrayList<>();
        int[] dp = new int[(60 * 24) + 20];
        for (var e : book_time) {
            int st = convertMin(e[0]);
            int en = convertMin(e[1]) + 10;
            dp[st]++; 
            dp[en]--;
        }
        int ans = 0;
        for (int i = 1; i <= 60 * 24 + 10; ++i) {
            dp[i] += dp[i - 1];
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    int convertMin(String time) {
        String[] sep = time.split(":");
        int hour = Integer.parseInt(sep[0]);
        int min = Integer.parseInt(sep[1]);
        return hour * 60 + min;
    }
}