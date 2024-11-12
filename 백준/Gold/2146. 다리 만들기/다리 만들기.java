import java.io.*;
import java.util.*;

// BFS, O(n * n * n * n)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		boolean[][] isVisited = new boolean[n][n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int seq = 1000;
		int ans = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == 1) {
					isVisited[i][j] = true;
					board[i][j] = ++seq;
					q.offer(new int[]{i, j});
				}
				List<int[]> side = new ArrayList<>();
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (isVisited[ny][nx]) continue;
						if (board[ny][nx] == 0) {
							isVisited[ny][nx] = true;
							side.add(new int[]{ny, nx});
							continue;
						}
						isVisited[ny][nx] = true;
						board[ny][nx] = seq;
						q.offer(new int[]{ny, nx});
					}
				}
				Queue<int[]> qq = new LinkedList<>(); // y, x, move
				for (var e : side) {
					boolean[][] isVisited2 = new boolean[n][n];
					isVisited2[e[0]][e[1]] = true;
					qq.offer(new int[]{e[0], e[1], 0});
					while (!qq.isEmpty()) {
						var cur = qq.poll();
						int y = cur[0];
						int x = cur[1];
						int move = cur[2];
						if (move >= ans)
							continue;
						for (int dir = 0; dir < 4; ++dir) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
							if (isVisited2[ny][nx]) continue;
							if (board[ny][nx] == 1) {
								ans = Math.min(ans, move + 1);
								break;
							}
							isVisited2[ny][nx] = true;
							qq.offer(new int[]{ny, nx, move + 1});
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
