import java.util.*;

public class Solution {
    
    int ans = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        List<Integer> weaks = new ArrayList<>();
        
        for (int i = 0; i < weak.length; ++i) weaks.add(weak[i]);
        
        for (int i = 0; i < weak.length - 1; ++i) weaks.add(n + weak[i]);
        
        dfs(new ArrayList<>(), new boolean[dist.length], dist, weaks, weak.length);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    void dfs(List<Integer> cur, boolean[] isVisited, int[] dist, List<Integer> weaks, int w) {
        
        if (cur.size() == dist.length) {
            for (int i = 0; i < w; ++i) {
                int st = weaks.get(i);
                int en = weaks.get(i + w - 1);
                for (int j = 0; j < cur.size(); ++j) {
                    st += cur.get(j);
                    if (st >= en) {
                        int t = j + 1;
                        ans = Math.min(ans, j + 1);
                        break;
                    }
                    for (int k = i + 1; k < i + w; ++k) {
                        if (weaks.get(k) > st) {
                            st = weaks.get(k);
                            break;
                        }
                    }
                }
            }
            return ;
        }
        for (int i = 0; i < dist.length; ++i) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            cur.add(dist[i]);
            dfs(cur, isVisited, dist, weaks, w);
            isVisited[i] = false;
            cur.remove(cur.size() - 1);
        }  
    }
}