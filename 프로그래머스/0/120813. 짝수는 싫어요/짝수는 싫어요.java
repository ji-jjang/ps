import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 2 == 1) {
                nums.add(i);
            }
        }
        int[] ans = new int[nums.size()];
        int idx = 0;
        for (var e : nums) {
            ans[idx++] = e;
        }
        return ans;
    }
}