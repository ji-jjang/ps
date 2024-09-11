/*
1. 아이디어: 
2. 시간복잡도: O(n)
3. 자료구조:
*/

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int sh = s / n;
        int re = s % n;
        
        if (sh < 1) return new int[]{-1};
        
        int[] ans = new int[n];
        Arrays.fill(ans, sh);
    
        for (int i = 0; i < re; ++i) {
            ans[n - i - 1] += 1;
        }
        return ans;
    }
}