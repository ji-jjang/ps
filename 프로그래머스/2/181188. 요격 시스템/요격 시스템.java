import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
	
        int ans = 0;
        int en = -1;
        for (var target : targets) {
            if (target[0] >= en) {
                en = target[1];
                ++ans;
            }
        }
        return ans;
    }
}