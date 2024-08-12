import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        rank.put(6, 1);
        rank.put(5, 2);
        rank.put(4, 3);
        rank.put(3, 4);
        rank.put(2, 5);
        rank.put(1, 6);
        rank.put(0, 6);

        for (var e : win_nums) m.put(e, 1);
        
        int score = 0;
        int zeroCnt = 0;
        int[] ans = new int[2];
        for (var e : lottos) {
            score += m.getOrDefault(e, 0);
            if (e == 0) ++zeroCnt;
        }
        ans[0] = rank.get(score + zeroCnt);
        ans[1] = rank.get(score);
        
        return ans;
    }
}