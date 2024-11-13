import java.io.*;
import java.util.*;

// BFS, O(V)
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] token = br.readLine().split(" ");
		int n = Integer.parseInt(token[0]);
		int k = Integer.parseInt(token[1]);

		Queue<int[]> q = new LinkedList<>(); // location, time
		boolean[] isVisited = new boolean[150_001];
		int[] path = new int[150_001];

		isVisited[n] = true;
		q.offer(new int[]{n, 0});
		boolean isArrive = false;
		int lot, time = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			lot = cur[0];
			time = cur[1];
			if (lot == k) {
				break;
			}
			if (lot * 2 <= 150_000 && !isVisited[lot * 2]) {
				path[lot * 2] = lot;
				isVisited[lot * 2] = true;
				q.offer(new int[]{lot * 2, time + 1});
			}
			if (lot + 1 <= 100_000 && !isVisited[lot + 1]) {
				path[lot + 1] = lot;
				isVisited[lot + 1] = true;
				q.offer(new int[]{lot + 1, time + 1});
			}
			if (lot - 1 >= 0 && !isVisited[lot - 1]) {
				path[lot - 1] = lot;
				isVisited[lot - 1] = true;
				q.offer(new int[]{lot - 1, time + 1});
			}
		}
		List<Integer> ret = new ArrayList<>();
		for (int i = k; i != n; i = path[i]) {
			ret.add(i);
		}
		ret.add(n);
		Collections.reverse(ret);
		StringBuilder sb = new StringBuilder();
		sb.append(time + "\n");
		for (var e : ret) {
			sb.append(e + " ");
		}
		System.out.println(sb);
	}
}
