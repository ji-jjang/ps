class Solution {
    public int solution(String s) {
        int n = s.length();
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, getPalindromeLength(s, i, i) - 1);
            ans = Math.max(ans, getPalindromeLength(s, i, i + 1));
        }

        return ans;
    }

    int getPalindromeLength(String s, int l, int r) {
        int n = s.length();
        
        int len = 0;
        while (l >= 0 && r < n) {
            if (s.charAt(l) == s.charAt(r)) {
                len += 2;
                --l;
                ++r;
            } else {
                break;
            }
        }
        
        return len;
    }
}
