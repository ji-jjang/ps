import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new LinkedList<>(); // location, moveCount
		boolean[] isVisited = new boolean[100_001];
		q.offer(new int[]{n, 0});

		while (!q.isEmpty()) {

			var cur = q.poll();
			int lot = cur[0];
			int move = cur[1];
			if (lot == k) {
				System.out.println(move);
				break;
			}

			if (lot - 1 >= 0 && !isVisited[lot - 1]) {
				isVisited[lot - 1] = true;
				q.offer(new int[]{lot - 1, move + 1});
			}
			if (lot + 1 <= 100_000 && !isVisited[lot + 1]) {
				isVisited[lot + 1] = true;
				q.offer(new int[]{lot + 1, move + 1});
			}
			if (lot * 2 <= 100_000 && !isVisited[lot * 2]) {
				isVisited[lot * 2] = true;
				q.offer(new int[]{lot * 2, move + 1});
			}
		}
	}
}
