import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new LinkedList<>(); // pos, time
		boolean[] isVisited = new boolean[150_001];
		int[] path = new int[150_001];
		isVisited[n] = true;
		q.offer(new int[]{n, 0});
		
		while (!q.isEmpty()) {
			var cur = q.poll();
			int pos = cur[0];
			int time = cur[1];
			if (pos == k) {
				System.out.println(time);
				break;
			}
			if (pos - 1 >= 0 && !isVisited[pos - 1]) {
				isVisited[pos - 1] = true;
				path[pos - 1] = pos;
				q.offer(new int[]{pos - 1, time + 1});
			}
			if (pos * 2 <= 150_000 && !isVisited[pos * 2]) {
				isVisited[pos * 2] = true;
				path[pos * 2] = pos;
				q.offer(new int[]{pos * 2, time + 1});
			}
			if (pos + 1 <= 100_000 && !isVisited[pos + 1]) {
				isVisited[pos + 1] = true;
				path[pos + 1] = pos;
				q.offer(new int[]{pos + 1, time + 1});
			}
		}
		int cur = k;
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.insert(0, cur + " ");
			if (cur == n) break;
			cur = path[cur];
		}
		System.out.println(sb);
	}
}
