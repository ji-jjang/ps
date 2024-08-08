import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		int[][] tmp = new int[n][n];
		boolean[][] isVisited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dy[] = {-1, 0, 1, 0};
		int dx[] = {0, 1, 0, -1};
		int ans = 0;

		for (int h = 0; h <= 100; ++h) {
			
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					tmp[i][j] = board[i][j] - h;
					if (tmp[i][j] < 0) tmp[i][j] = 0;
					isVisited[i][j] = false;
				}
			}
			q.clear();

			int safeArea = 0;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (tmp[i][j] != 0 && !isVisited[i][j]) {
						++safeArea;
						isVisited[i][j] = true;
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
							if (tmp[ny][nx] == 0 || isVisited[ny][nx]) continue;
							isVisited[ny][nx] = true;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
			ans = Math.max(ans, safeArea);
		}
		System.out.println(ans);
	}
}
