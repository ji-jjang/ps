class Solution {
    public int solution(String my_string, String is_suffix) {
        int ans = 0;
        if (my_string.endsWith(is_suffix))
            ans = 1;
        return ans;
    }
}