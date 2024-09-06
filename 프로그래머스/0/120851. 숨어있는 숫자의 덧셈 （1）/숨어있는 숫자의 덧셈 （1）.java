class Solution {
    public int solution(String my_string) {
        int ans = 0;
        for (var c : my_string.toCharArray()) {
            if (c >= '0' && c <= '9')
                ans += c - '0';
        }
        return ans;
    }
}