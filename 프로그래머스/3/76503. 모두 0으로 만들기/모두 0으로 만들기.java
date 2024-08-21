import java.util.*;

class Solution {
	List<Integer> adj[];
	boolean[] isVisited;
	long[] v;
	long ans = 0;
	public long solution(int[] a, int[][] edges) {
			
		v = new long[a.length];
		for(int i = 0; i < a.length; ++i) {
			v[i] = a[i];
			ans += a[i];
		}
		if (ans != 0) return -1;

		adj = new ArrayList[a.length];
		isVisited = new boolean[a.length];
		for(int i = 0; i < a.length; ++i) {
			adj[i] = new ArrayList<>();
		}
		
		for(var edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}
		
		dfs(0);
		
		return ans;
	}
	
	long dfs(int now) {
        
		isVisited[now] = true;
		for (int i = 0; i < adj[now].size(); ++i) {
            int nxt = adj[now].get(i);
			if (isVisited[nxt]) continue;
			v[now] += dfs(nxt);
		}
		ans += Math.abs(v[now]);
        return v[now];
	}
}

