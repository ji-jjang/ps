class Solution {
    public int solution(int[] array, int height) {
        
        int ans = 0;
        for (var e : array) {
            if (e > height)
                ++ans;
        }
        return ans;
    }
}