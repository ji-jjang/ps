import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<List<int[]>>> switches = new ArrayList<>();

		boolean[][] isVisited = new boolean[n + 1][n + 1];
		int[][] board = new int[n + 1][n + 1];

		for (int i = 0; i <= n; ++i) {
			switches.add(new ArrayList<>());
			for (int j = 0; j <= n; ++j) {
				switches.get(i).add(new ArrayList<>());
			}
		}
		for (int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int y, x, a, b;
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			switches.get(y).get(x).add(new int[]{a, b});
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();

		board[1][1] = 1; // light off: 0, light on: 1
		isVisited[1][1] = true;
		q.offer(new int[]{1, 1});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			for (var e : switches.get(y).get(x)) {
				int yy = e[0];
				int xx = e[1];
				if (isVisited[yy][xx]) continue;
				board[yy][xx] = 1;
				for (int dir = 0; dir < 4; ++dir) {
					int nyy = yy + dy[dir];
					int nxx = xx + dx[dir];
					if (nyy < 1 || nyy > n || nxx < 1 || nxx > n) continue;
					if (!isVisited[nyy][nxx]) continue;
					isVisited[yy][xx] = true;
					q.offer(new int[]{yy, xx});
					break;
				}
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 1 || ny > n || nx < 1 || nx > n) continue;
				if (board[ny][nx] != 1 || isVisited[ny][nx]) continue;
				isVisited[ny][nx] = true;
				q.offer(new int[]{ny, nx});
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (board[i][j] == 1) ++ans;
			}
		}
		System.out.println(ans);
	}
}
