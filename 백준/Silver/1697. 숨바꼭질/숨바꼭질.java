import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean isVisited[] = new boolean[100_001];

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{n, 0});
		int ans = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int time = cur[1];
			if (y == k) {
				ans = Math.min(ans, time);
				break; 
			}
			if (y - 1 >= 0 && !isVisited[y - 1]) {
				isVisited[y - 1] = true;
				q.offer(new int[]{y - 1, time + 1});
			}
			if (y + 1 <= 100_000 && !isVisited[y + 1]) {
				isVisited[y + 1] = true;
				q.offer(new int[]{y + 1, time + 1});
			}
			if (y * 2 <= 100_000 && !isVisited[y * 2]) {
				isVisited[y * 2] = true;
				q.offer(new int[]{y * 2, time + 1});
			}
		}
		System.out.println(ans);
	}
}
