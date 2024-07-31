import java.util.*;

class Solution {

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = -1;
        int maxCop = -1;
        for (var p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        int[][] isVisited = new int[151][151];
        for (var row : isVisited) Arrays.fill(row, Integer.MAX_VALUE);

        dfs(alp, cop, 0, maxAlp, maxCop, problems, isVisited);

        return isVisited[maxAlp][maxCop];
    }

    void dfs(int alp, int cop, int cnt, int maxAlp, int maxCop, int[][] problems, int[][] isVisited) {
        if (alp > maxAlp) alp = maxAlp;
        
        if (cop > maxCop) cop = maxCop;

        if (isVisited[alp][cop] <= cnt) return;
        
        isVisited[alp][cop] = Math.min(isVisited[alp][cop], cnt);

        if (alp == maxAlp && cop == maxCop) return;
        
        dfs(alp + 1, cop, cnt + 1, maxAlp, maxCop, problems, isVisited);
        
        dfs(alp, cop + 1, cnt + 1, maxAlp, maxCop, problems, isVisited);
        
        for (int[] problem : problems) {
            if (alp >= problem[0] && cop >= problem[1]) {
                dfs(alp + problem[2], cop + problem[3], cnt + problem[4], maxAlp, maxCop, problems, isVisited);
            }
        }
    }
}
