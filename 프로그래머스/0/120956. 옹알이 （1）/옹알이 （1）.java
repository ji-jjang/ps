import java.util.*;

class Solution {    
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int cnt = 0;

        for (var bab : babbling) {
            
            for (var word : words) {
                bab = bab.replace(word, " ");
            }
            
            if (bab.trim().isEmpty()) {
                cnt++;
            }
        }

        return cnt;
    }
}