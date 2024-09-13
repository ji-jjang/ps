/*
아이디어: 정렬
시간복잡도: O(n)
자료구조:
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = {0, 0};
        int sum = brown + yellow;
        for (int i = 1; i <= sum / 2; ++i) {
            if (sum % i != 0)
                continue;
            int j = sum / i;
            int ySum = (i - 2) * (j - 2);
            if (ySum == yellow) {
                ans[0] = j;
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}