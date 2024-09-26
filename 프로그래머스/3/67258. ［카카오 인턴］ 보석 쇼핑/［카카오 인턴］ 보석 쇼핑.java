import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totals = gemTypes.size();

        Map<String, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int minLen = gems.length + 1;
        int st = 0;

        while (true) {
            if (map.size() == totals) {
                if (r - l < minLen) {
                    minLen = r - l;
                    st = l;
                }

                String leftGem = gems[l];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }
                ++l;
            } else {
                if (r == gems.length) break;

                String rightGem = gems[r];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
                ++r;
            }
        }

        int[] ans = new int[2];
        ans[0] = st + 1;
        ans[1] = st + minLen;

        return ans;
    }
}


