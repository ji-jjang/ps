import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        Map<Integer, Integer> m = new HashMap<>();
        
        
        for (var e : array) {
            m.put(e, m.getOrDefault(e, 0) + 1);
        }
        
        boolean isUnique = true;
        int maxValue = 0;
        int ans = 0;
        for (var e : m.entrySet()) {
            int cur = e.getValue();
            
            if (maxValue < cur) {
                maxValue = cur;
                isUnique = true;
                ans = e.getKey();
            } else if (maxValue == cur) {
                isUnique = false;
            }
        }
        
        return isUnique ? ans : -1;
    }
}