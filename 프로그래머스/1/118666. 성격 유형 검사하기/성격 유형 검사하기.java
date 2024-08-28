import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < survey.length; ++i) {
            int score = choices[i];

            if (score < 4) {
                char c = survey[i].charAt(0);
                m.put(c, m.getOrDefault(c, 0) + 4 - score);
            } else {
                char c = survey[i].charAt(1);
                m.put(c, m.getOrDefault(c, 0) + score - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        sb.append(m.getOrDefault('R', 0) >= m.getOrDefault('T', 0) ? 'R' : 'T')
            .append(m.getOrDefault('C', 0) >= m.getOrDefault('F', 0) ? 'C' : 'F')
            .append(m.getOrDefault('J', 0) >= m.getOrDefault('M', 0) ? 'J' : 'M')
            .append(m.getOrDefault('A', 0) >= m.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();    
    }
}