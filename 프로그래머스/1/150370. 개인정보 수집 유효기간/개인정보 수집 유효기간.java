import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int tod = convertDays(today);
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < privacies.length; ++i) {
            String[] splitP = privacies[i].split(" ");
            int exp = 0;
            for (var term : terms) {
                if (term.charAt(0) == splitP[1].charAt(0)) {
                    exp = Integer.parseInt(term.substring(2)) * 28;
                }
            }
            int collectDay = convertDays(splitP[0]);
            if (collectDay + exp <= tod) {
                l.add(i + 1);
            }
        }
        int[] ans = new int[l.size()];
        int idx = 0;
        for (var e : l) {
            ans[idx++] = e;
        }
        return ans;
    }
    
    int convertDays(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return year * 12 * 28 + month * 28 + day;
    }
}