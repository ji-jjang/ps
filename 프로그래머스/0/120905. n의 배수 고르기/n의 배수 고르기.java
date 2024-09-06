import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        List<Integer> nums = new ArrayList<>();
        
        for (var e : numlist) {
            if (e % n == 0)
                nums.add(e);
        }
        
        int[] ans = new int[nums.size()];
        int idx = 0;
        for (var e : nums) {
            ans[idx++] = e;
        }
        return ans;
    }
}