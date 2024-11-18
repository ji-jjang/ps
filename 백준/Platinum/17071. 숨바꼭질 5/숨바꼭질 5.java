import java.io.*;
import java.util.*;

// BFS, O(500_000)
public class Main {

	final static int MAX = 500_000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);

		if (n == k) {
			System.out.println(0);
			return ;
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[MAX + 1][2];
		isVisited[n][0] = true;
		q.offer(n);

		int ans = Integer.MAX_VALUE;
		int time = 0;
		while (!q.isEmpty()) {
			k += time;

			if (k > MAX) break;

			if (isVisited[k][time % 2]) {
				ans = time;
				break;
			}

			int size = q.size();

			for (int i = 0; i < size; ++i) {
				int pos = q.poll();

				for (var nxtPos : new int[]{pos - 1 , pos + 1, pos * 2}) {
					if (nxtPos >= 0 && nxtPos <= MAX && !isVisited[nxtPos][(time + 1) % 2]) {
						isVisited[nxtPos][(time + 1) % 2] = true;
						q.offer(nxtPos);
					}
				}
			}
			++time;
		}
		if (ans > MAX) ans = -1;
		System.out.println(ans);
	}
}
