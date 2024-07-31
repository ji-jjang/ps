import java.util.*;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> ret = new ArrayList<>();
        
        hanoi(n, 1, 3, ret);
        
        int[][] ans = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); ++i) ans[i] = ret.get(i);
        
        return ans;
    }
    
    void hanoi(int n, int left, int right, ArrayList<int[]> ret) {
        if (n == 1) {
            ret.add(new int[]{left, right});
            return;
        }
        hanoi(n - 1, left, 6 - left - right, ret);
        ret.add(new int[]{left, right});
        hanoi(n - 1, 6 - left - right, right, ret);
    }
}