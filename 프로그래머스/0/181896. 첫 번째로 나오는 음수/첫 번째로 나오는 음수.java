class Solution {
    public int solution(int[] num_list) {
        int ans = 0;
        boolean isFind = false;
        for (var e : num_list) {
            if (e < 0) {
                isFind = true;
                break;
            }
            ++ans;
        }
        return isFind ? ans : -1;
    }
}