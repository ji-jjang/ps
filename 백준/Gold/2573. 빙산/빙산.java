import java.io.*;
import java.util.*;

// BFS, O(year * r * c)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];

		int maxHeight = 0;
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, board[i][j]);
			}
		}

		for (int year = 1; year <= 4000; ++year) {
			int[][] tmp = new int[r][c];
			for (int i = 1; i < r - 1; ++i) {
				for (int j = 1; j < c - 1; ++j) {
					int cnt = 0;
					for (int dir = 0; dir < 4; ++dir) {
						int ny = i + dy[dir];
						int nx = j + dx[dir];
						if (board[ny][nx] == 0)
							++cnt;
					}
					tmp[i][j] = board[i][j] - cnt;
					if (tmp[i][j] < 0) tmp[i][j] = 0;
				}
			}
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					board[i][j] = tmp[i][j];
				}
			}
			Queue<int[]> q = new LinkedList<>();
			int cnt = 0;
			for (int i = 1; i < r - 1; ++i) {
				for (int j = 1; j < c - 1; ++j) {
					if (tmp[i][j] > 0) {
						++cnt;
						tmp[i][j] = -1;
						q.offer(new int[]{i, j});
					}
					while (!q.isEmpty()) {
						var cur = q.poll();
						int y = cur[0];
						int x = cur[1];
						for (int dir = 0; dir < 4; ++dir) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
							if (tmp[ny][nx] <= 0) continue;
							tmp[ny][nx] = -1;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
			if (cnt > 1) {
				System.out.println(year);
				return;
			}
		}
		System.out.println(0);
	}
}
