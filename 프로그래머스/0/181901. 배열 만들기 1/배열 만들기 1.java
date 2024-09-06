import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % k == 0)
                nums.add(i);
        }
        
        int[] ans = new int[nums.size()];
        int idx = 0;
        for (var e : nums) {
            ans[idx++] = e;
        }
        return ans;
    }
}