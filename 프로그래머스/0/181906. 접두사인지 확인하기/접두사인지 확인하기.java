class Solution {
    public int solution(String my_string, String is_prefix) {
        int ans = 0;
        if (my_string.startsWith(is_prefix))
            ans = 1;
        return ans;
    }
}