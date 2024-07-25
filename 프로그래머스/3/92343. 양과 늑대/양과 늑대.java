import java.util.*;

class Solution {
    
    int ans = 0;
    public int solution(int[] info, int[][] edges) {
        
        int n = info.length;
        int[] lc = new int[n];
        int[] rc = new int[n];
        int[] sheep = new int[n];
        
        Arrays.fill(lc, -1);
        Arrays.fill(rc, -1);
        for (int i = 0; i < n - 1; ++i) {
            if (lc[edges[i][0]] == -1) 
                lc[edges[i][0]] = edges[i][1];
            else 
                rc[edges[i][0]] = edges[i][1];
        }
        
        dfs(0, 0, 0, new ArrayList<>(), lc, rc, info);
        
        return ans;
    }
    
    void dfs(int cur, int sheep, int wolf, List<Integer> nxts, int[] lc, int[] rc, int[] info) {
        
        if (info[cur] == 0) 
            ++sheep;
        else 
            ++wolf;
        
        if (sheep <= wolf) 
            return;
        
        ans = Math.max(ans, sheep);
        
        List<Integer> newNxts = new ArrayList<>(nxts);
        if (lc[cur] != -1) newNxts.add(lc[cur]);
        if (rc[cur] != -1) newNxts.add(rc[cur]);
        
        for (var nxt : newNxts) {
            List<Integer> tmps = new ArrayList<>(newNxts);
            tmps.remove((Integer)nxt);
            dfs(nxt, sheep, wolf, tmps, lc, rc, info);
        }  
    }
}