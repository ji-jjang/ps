import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[] floor = new int[f + 1];
		boolean[] isVisited = new boolean[f + 1];

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{s, 0});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int pos = cur[0];
			int time = cur[1];
			if (pos == g) {
				System.out.println(time);
				return;
			}
			if (pos + u <= f && !isVisited[pos + u]) {
				isVisited[pos + u] = true;
				q.offer(new int[]{pos + u, time + 1});
			}
			if (pos - d >= 1 && !isVisited[pos - d]) {
				isVisited[pos - d] = true;
				q.offer(new int[]{pos - d, time + 1});
			}
		}
		System.out.println("use the stairs");
	}
}
