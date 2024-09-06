import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < num_list.length; i += n) {
            nums.add(num_list[i]);
        }
        
        int[] ans = new int[nums.size()];
        int idx = 0;
        for (var e : nums)
            ans[idx++] = e;
        return ans;
    }
}