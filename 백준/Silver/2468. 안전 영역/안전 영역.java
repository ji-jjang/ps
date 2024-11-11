import java.io.*;
import java.util.*;

// BFS, O(h * n * n)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 1;
		int[][] tmp = new int[n][n];
		for (int h = 1; h <= 100; ++h) {
			q = new LinkedList<>();
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					tmp[i][j] = board[i][j] - h;
					if (tmp[i][j] < 0)
						tmp[i][j] = 0;
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (tmp[i][j] != 0) {
						++cnt;
						tmp[i][j] = 0;
						q.offer(new int[]{i, j});
					}
					while (!q.isEmpty()) {
						var cur = q.poll();
						int y = cur[0];
						int x = cur[1];
						for (int dir = 0; dir < 4; ++dir) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
							if (tmp[ny][nx] == 0) continue;
							tmp[ny][nx] = 0;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
