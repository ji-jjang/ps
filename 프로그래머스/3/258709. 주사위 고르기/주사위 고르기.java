import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        
        boolean[] isVisited = new boolean[n];
        List<int[]> dices = new ArrayList<>();
        
        dfs(0, new int[n / 2], n, isVisited, dices);
        
        int[] ans = new int[n / 2];
        int max = -1;
        for (var d : dices) {
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < d.length; ++i) {
                s.add(d[i]);
            }
            List<int[]> aDice = new ArrayList<>();
            List<int[]> bDice = new ArrayList<>();
            
            for (int i = 0; i < n; ++i) {
                if (s.contains(i))
                    aDice.add(dice[i]);
                else
                    bDice.add(dice[i]);
            }

            int aWinCnt = calculateWin(aDice, bDice);
            
            if (aWinCnt > max) {
                max = aWinCnt;
                for (int i = 0; i < d.length; ++i) {
                    ans[i] = d[i] + 1;
                }
            }
        }
        
        return ans;
     }
    
     void dfs(int depth, int[] cur, int n, boolean[] isVisited, List<int[]> dices) {
        if (depth == n / 2) {
            dices.add(cur.clone());
            return;
        }
        
        int st = depth == 0 ? 0 : cur[depth - 1] + 1; 
        for (int i = st; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                cur[depth] = i;
                dfs(depth + 1, cur, n, isVisited, dices);
                isVisited[i] = false;
            }
        }
    }
    
    int calculateWin(List<int[]> aDice,  List<int[]> bDice) {
        Map<Integer, Integer> aSum = new HashMap<>();
        Map<Integer, Integer> bSum = new HashMap<>();

        dfs2(0, 0, aDice, aSum);
        dfs2(0, 0, bDice, bSum);
        
        int aWinCnt = 0;
        for (var a : aSum.entrySet()) {
            for (var b : bSum.entrySet()) {
                if (a.getKey() > b.getKey()) {
                    aWinCnt += (a.getValue() * b.getValue());
                }
            }
        }
        
        return aWinCnt;
    }
    
    void dfs2(int depth, int sum, List<int[]> dice, Map<Integer, Integer> sums) {
        if (depth == dice.size()) {
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            return ;
        }
        for (var score : dice.get(depth)) {
            dfs2(depth + 1, sum + score, dice, sums);
        }
    }
}