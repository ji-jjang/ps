import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] isVisited = new boolean[150_001];
		Queue<int[]> q = new LinkedList<>();

		isVisited[n] = true;
		q.offer(new int[]{n, 0});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int pos = cur[0];
			int move = cur[1];
			if (pos == k) {
				System.out.println(move);
				break;
			}
			if (pos * 2 <= 150_000 && !isVisited[pos * 2]) {
				isVisited[pos * 2] = true;
				q.offer(new int[]{pos * 2, move});
			}
			if (pos - 1 >= 0 && !isVisited[pos - 1]) {
				isVisited[pos - 1] = true;
				q.offer(new int[]{pos - 1, move + 1});
			}
			if (pos + 1 <= 100_000 && !isVisited[pos + 1]) {
				isVisited[pos + 1] = true;
				q.offer(new int[]{pos + 1, move + 1});
			}
		}
	}
}

