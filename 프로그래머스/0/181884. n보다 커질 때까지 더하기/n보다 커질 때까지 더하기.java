class Solution {
    public int solution(int[] numbers, int n) {
        
        int ans = 0;
        for (var e : numbers) {
            ans += e;
            if (ans > n)
                break;
        }
        return ans;
    }
}