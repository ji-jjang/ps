class Solution {
    public int[] solution(int money) {
        int[] ans = new int[2];
        ans[0] = money / 5500;
        ans[1] = money % 5500;
        return ans;
    }
}