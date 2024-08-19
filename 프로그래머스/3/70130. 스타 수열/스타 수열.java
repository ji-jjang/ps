import java.util.*;

class Solution {
    public int solution(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : a) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (var key : m.keySet()) {
            if (m.get(key) * 2 <= ans) {
                continue;  
            }

            int len = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]) {
                    len += 2; 
                    i++; 
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}