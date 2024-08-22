import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if (n == k) {
			System.out.println(0);
			return;
		}

		int[][] dist = new int[500_004][2];
		Queue<int[]> q = new LinkedList<>();
		dist[n][0] = 0;
		q.offer(new int[]{n, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int pos = cur[0];
			int time = cur[1];
			int nxtTime = time + 1;

			if (pos * 2 <= 500_000 && dist[pos * 2][nxtTime % 2] == 0) {
				dist[pos * 2][nxtTime % 2] = nxtTime;
				q.offer(new int[]{pos * 2, nxtTime});
			}
			if (pos - 1 >= 0 && dist[pos - 1][nxtTime % 2] == 0) {
				dist[pos - 1][nxtTime % 2] = nxtTime;
				q.offer(new int[]{pos - 1, nxtTime});
			}
			if (pos + 1 <= 500_000 && dist[pos + 1][nxtTime % 2] == 0) {
				dist[pos + 1][nxtTime % 2] = nxtTime;
				q.offer(new int[]{pos + 1, nxtTime});
			}
		}
		boolean isFound = false;
		int ans = 0;
		while (k <= 500000) {
			if (dist[k][ans % 2] <= ans) {
				isFound = true;
				break;
			}
			++ans;
			k += ans;
		}

		if (isFound) {
			System.out.println(ans);
			return;
		}
		System.out.println(-1);
	}
}
