import java.io.*;
import java.util.*;

// BFS, O(f)
public class Main {

	static Queue<int[]> q = new LinkedList<>(); // floor, moveCountjj

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[f + 1];
		boolean isArrive = false;
		isVisited[s] = true;
		q.offer(new int[]{s, 0});
		int ans = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int floor = cur[0];
			int moveCount = cur[1];
			if (floor == g) {
				isArrive = true;
				ans = moveCount;
				break;
			}
			
			if (floor - d >= 1 && !isVisited[floor - d]) {
				isVisited[floor - d] = true;
				q.offer(new int[]{floor - d, moveCount + 1});
			}
			if (floor + u <= f && !isVisited[floor + u]) {
				isVisited[floor + u] = true;
				q.offer(new int[]{floor + u, moveCount + 1});
			}
		}
		if (!isArrive) {
			System.out.println("use the stairs");
			return;
		}
		System.out.println(ans);
	}
}
