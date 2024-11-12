import java.io.*;
import java.util.*;

// BFS, O(t * n)
public class Main {

	static Queue<Integer> q;
	static Set<Integer> cycles;
	static int[] stu;
	static boolean[] isVisited;
	static boolean[] isFinished;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			stu = new int[n + 1];
			isVisited = new boolean[n + 1];
			isFinished = new boolean[n + 1];
			cycles = new HashSet<>();
			for (int i = 1; i <= n; ++i) {	
				stu[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; ++i) {
				if (!isVisited[i]) {
					bfs(i);
				}
			}
			sb.append(n - cycles.size() + "\n");
		}
		System.out.println(sb);
	}
	static void bfs(int st) {

		q = new LinkedList<>();
		Map<Integer, Integer> path = new HashMap<>(); // cur, parent

		isVisited[st] = true;
		path.put(st, null);
		q.offer(st);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int nxt = stu[cur];
			if (!isVisited[nxt]) {
				isVisited[nxt] = true;
				q.add(nxt);
				path.put(nxt, cur);
			} else {
				if (!isFinished[nxt]) {

					while (cur != nxt) {
						cycles.add(cur);
						cur = path.get(cur);
					}
					cycles.add(nxt);
				}
				break;
			}
		}
		for (var e : path.keySet()) {
			isFinished[e] = true;
		}
	}
}
