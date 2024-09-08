import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        
        List<Integer> nums = new ArrayList<>();
        for (var e : num_list) {
            nums.add(e);
        }
        int last = 0;
        if (num_list[n - 1] > num_list[n - 2]) {
            last = num_list[n - 1] - num_list[n - 2];
        }
        else 
            last = num_list[n - 1] * 2;
        nums.add(last);
        int idx = 0;
        int[] ans = new int[nums.size()];
        for (var e : nums) {
            ans[idx++] = e;
        }
        return ans;
    }
}