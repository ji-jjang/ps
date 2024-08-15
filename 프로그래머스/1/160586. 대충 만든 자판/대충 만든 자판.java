import java.util.*;

class Solution {
    
    public int[] solution(String[] keymap, String[] targets) {
        
        Map<Character, Integer> m = new HashMap<>();
        
        for (int i = 0; i < keymap.length; i++) {
            String keys = keymap[i];
            for (int j = 0; j < keys.length(); j++) {
                char c = keys.charAt(j);
                int cnt = j + 1;
                m.put(c, Math.min(m.getOrDefault(c, cnt), cnt));
            }
        }
        
        int[] ans = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int cnt = 0;
            boolean possible = true;
            
            for (char c : target.toCharArray()) {
                if (m.containsKey(c)) {
                    cnt += m.get(c);
                } else {
                    possible = false;
                    break;
                }
            }
            ans[i] = possible ? cnt : -1;
        }
        
        return ans;
    }
}