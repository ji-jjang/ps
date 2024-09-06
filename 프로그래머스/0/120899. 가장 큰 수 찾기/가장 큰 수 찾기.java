class Solution {
    public int[] solution(int[] array) {
        int[] ans = new int[2];
        
        int idx = 0;
        for (var e : array) {
            if (ans[0] < e) {
                ans[0] = e;
                ans[1] = idx;
            }
            ++idx;
        }
        return ans;
    }
}