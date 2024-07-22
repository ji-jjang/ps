import java.util.*;

class Solution {
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < paths.length; ++i) {
            adj[paths[i][0]].add(new int[]{paths[i][2], paths[i][1]});
            adj[paths[i][1]].add(new int[]{paths[i][2], paths[i][0]});
        }
        
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (var gate : gates) {
            pq.add(new int[] {0, gate});
            d[gate] = 0;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curWeight = cur[0];
            int curNode = cur[1];

            if (d[curNode] != curWeight) continue;
            if (isSummit(curNode, summits)) continue;

            for (var nxt : adj[curNode]) {
                int newWeight = Math.max(curWeight, nxt[0]);
                if (newWeight < d[nxt[1]]) {
                    d[nxt[1]] = newWeight;
                    pq.add(new int[] {newWeight, nxt[1]});
                }
            }
        }

        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (var s : summits) {
            if (d[s] < minIntensity) {
                minIntensity = d[s];
                minSummit = s;
            } 
        }

        return new int[] {minSummit, minIntensity};
    }
    
    boolean isSummit(int cur, int[] summits) {
        for (var e : summits) if (cur == e) return true;
        return false;
    }
    
}
