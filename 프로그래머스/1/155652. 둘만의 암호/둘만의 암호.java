import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] str = s.toCharArray();
        char[] alpha = new char[26];
        int idx = 0;
        for (char c = 'a'; c <= 'z'; ++c) {
            alpha[idx++] = c;
        }

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = str[i];
            for (int j = 0; j < index; j++) {
                c = alpha[(c - 'a' + 1) % 26];
                boolean isContain = false;
                for (var sk : skip.toCharArray()) {
                    if (sk == c) {
                        isContain = true;
                        break;
                    }
                }
                if (isContain)
                    --j;
            }
            ans += c;
        }

        return ans;
    }
}