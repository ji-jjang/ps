import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<List<Integer>> patterns = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            patterns.add(new ArrayList<>());
        }

        patterns.get(0).addAll(Arrays.asList(1, 2, 3, 4, 5));
        patterns.get(1).addAll(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        patterns.get(2).addAll(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        
        int[] player = new int[3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < answers.length; ++j) {
                if (patterns.get(i).get(j % patterns.get(i).size()) == answers[j]) {
                    player[i]++;
                }
            }
        }

        int maxScore = Math.max(player[0], Math.max(player[1], player[2]));

        List<Integer> maxPlayers = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            if (player[i] == maxScore) {
                maxPlayers.add(i + 1); 
            }
        }

        int[] ans = new int[maxPlayers.size()];
        for (int i = 0; i < maxPlayers.size(); ++i) {
            ans[i] = maxPlayers.get(i);
        }
        
        return ans;
    }
}