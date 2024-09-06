import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            nums.add(num_list[i]);
        }
        int idx = 0;
        int[] ans = new int[nums.size()];
        for (var e : nums) {
            ans[idx++] = e;
        }
        return ans;
    }
}