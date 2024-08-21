import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> x = new HashMap<>();
        Map<Character, Integer> y = new HashMap<>();
        
        for (var c : X.toCharArray()) {
            x.put(c, x.getOrDefault(c, 0) + 1);
        }
        for (var c : Y.toCharArray()) {
            y.put(c, y.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char i = '9'; i >= '1'; --i) {
            if (x.containsKey(i) && y.containsKey(i)) {
                int cnt = Math.min(x.get(i), y.get(i));
                for (int j = 0; j < cnt; ++j) {
                    sb.append(i);
                }
            }
        }
        if (x.containsKey('0') && y.containsKey('0')) {
            if (sb.length() > 0) {
                int cnt = Math.min(x.get('0'), y.get('0'));
                for (int j = 0; j < cnt; ++j) {
                    sb.append('0');
                }
            } else {
                sb.append('0');
            }
        }
        else {
            if (sb.length() < 1)
                sb.append("-1");
        }
        
        return sb.toString();
    }
}