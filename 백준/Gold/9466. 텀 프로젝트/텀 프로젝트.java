import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] students = new int[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; ++i) {
				students[i] = Integer.parseInt(st.nextToken());
			}

			boolean[] isVisited = new boolean[n + 1];
			boolean[] isFinished = new boolean[n + 1];
			int ans = 0;

			for (int i = 1; i <= n; i++) {
				if (!isVisited[i]) {
					ans += bfs(i, students, isVisited, isFinished);
				}
			}
			System.out.println(ans);
		}
	}
	static int bfs(int st, int[] students, boolean[] isVisited, boolean[] isFinished) {
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Integer> m = new HashMap<>();

		m.put(st, 0);
		isVisited[st] = true;
		q.add(st);

		int cycleLength = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			int nxt = students[cur];

			if (!isVisited[nxt]) {
				isVisited[nxt] = true;
				q.add(nxt);
				m.put(nxt, m.get(cur) + 1);
			} else {
				if (!isFinished[nxt]) {
					cycleLength = m.get(cur) - m.get(nxt) + 1;
				}
				break;
			}
		}

		for (int node : m.keySet()) {
			isFinished[node] = true;
		}

		return m.size() - cycleLength;
	}
}
