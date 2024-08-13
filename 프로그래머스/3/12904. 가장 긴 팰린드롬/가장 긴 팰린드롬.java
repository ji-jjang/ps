class Solution {
    public int solution(String s) {
        int n = s.length();
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalinDrome(s, i, j)) {
                    int len = j - i + 1;
                    if (ans < len) {
                        ans = len;
                    }
                }
            }
        }
        return ans;
    }
    
    boolean isPalinDrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                ++l;
                --r;
            } else {
                return false;
            }
        }
        return true;
    }
}