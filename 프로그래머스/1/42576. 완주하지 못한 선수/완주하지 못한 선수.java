import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> m = new HashMap<>();
        
        for (var e : participant) 
            m.put(e, m.getOrDefault(e, 0) + 1);
        for (var e : completion) 
            m.put(e, m.getOrDefault(e, 0) - 1);
        String ans = "";
        for (var e : m.keySet()) {
            if (m.get(e) > 0) {
                ans = e;
            }
        }
        return ans;
    }
}