import java.io.*;
import java.util.*;

// BFS, O(n)
// HammingDistance 이용
// K번째 비트가 0인지 1인지에 따라 비트를 하나씩 변경해주기
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		String[] tokens = br.readLine().split(" ");
		for (int i = 0; i < m; ++i) {
			int num = Integer.parseInt(tokens[i]);
			dist[num] = 0;
			q.offer(num);
		}

		int maxBitSize = 32 - Integer.numberOfLeadingZeros(n);
		while (!q.isEmpty()) {
			int num = q.poll();

			for (int k = 0; k < maxBitSize; ++k) {

				int nxt;
				if ((num & (1 << k)) != 0) {
					nxt = num & ~(1 << k);
				}
				else {
					nxt = num | (1 << k);
				}

				if (nxt > n || dist[nxt] >= 0) continue;

				dist[nxt] = dist[num] + 1;
				q.add(nxt);
			}
		}
		int ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = Math.max(ans, dist[i]);
		}

		System.out.println(ans);
	}
}
