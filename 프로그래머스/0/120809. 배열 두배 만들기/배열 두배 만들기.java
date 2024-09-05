class Solution {
    public int[] solution(int[] numbers) {
        int[] ans = new int[numbers.length];
        
        int idx = 0;
        for (var num : numbers) {
            ans[idx++] = num * 2;
        }
        return ans;
    }
}