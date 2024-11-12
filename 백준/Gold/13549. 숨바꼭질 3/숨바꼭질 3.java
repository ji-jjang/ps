import java.io.*;
import java.util.*;

// BFS, O(n * n * n * n)
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[150_004];
		Queue<int[]> q = new LinkedList<>();
		isVisited[n] = true;
		q.offer(new int[]{n, 0});

		while (!q.isEmpty()) {
			var cur = q.poll();
			int lot = cur[0];
			int time = cur[1];
			if (lot == k) {
				System.out.println(time);
				break;
			}
			if (lot * 2 <= 150_000 && !isVisited[lot * 2]) {
				isVisited[lot * 2] = true;
				q.offer(new int[]{lot * 2, time});
			}
			if (lot - 1 >= 0 && !isVisited[lot - 1]) {
				isVisited[lot - 1] = true;
				q.offer(new int[]{lot - 1, time + 1});
			}
			if (lot + 1 <= 100_000 && !isVisited[lot + 1]) {
				isVisited[lot + 1] = true;
				q.offer(new int[]{lot + 1, time + 1});
			}
		}
	}
}
