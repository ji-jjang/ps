import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        Map<String, List<Integer>> infoMap = new HashMap<>();
        
        for (String i : info) {
            String[] split = i.split(" ");
            String[] languages = {split[0], "-"};
            String[] positions = {split[1], "-"};
            String[] careers = {split[2], "-"};
            String[] soulFoods = {split[3], "-"};
            int score = Integer.parseInt(split[4]);
            
            for (String lang : languages) {
                for (String pos : positions) {
                    for (String career : careers) {
                        for (String soulFood : soulFoods) {
                            String key = lang + pos + career + soulFood;
                            infoMap.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
                        }
                    }
                }
            }
        }
        for (var scores : infoMap.values()) {
            scores.sort((a, b) -> Integer.compare(a, b));
        }
        
        int[] ans = new int[query.length];
        
        for (int i = 0; i < query.length; ++i) {
            String[] split = query[i].replaceAll(" and ", "").split(" ");
            String key = split[0];
            int target = Integer.parseInt(split[1]);
            
            if (infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                int idx = lowerBound(scores, target);
                ans[i] = scores.size() - idx;
            } else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
    
    int lowerBound(List<Integer> scores, int target) {
        int st = 0;
        int en = scores.size();
        while (st < en) {
            int mid = (st + en) >>> 1;
            if (scores.get(mid) >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}