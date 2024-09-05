class Solution {
    public int solution(int[] array, int n) {
        
        int ans = 0;
        for (var e : array) {
            if (e == n)
                ++ans;
        }
        return ans;
    }
}