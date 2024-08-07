import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		boolean[][] isVisited = new boolean[n][n];

		for (int i = 0; i < n; ++i) {
			String line = br.readLine();
			for (int j = 0; j < n; ++j) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();
		List<Integer> areas = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int cnt = 0;
				if (!isVisited[i][j] && board[i][j] == 1) {
					isVisited[i][j] = true;
					q.offer(new int[]{i, j});
					++cnt;
				}
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (board[ny][nx] == 0 || isVisited[ny][nx]) continue;
						++cnt;
						isVisited[ny][nx] = true;
						q.offer(new int[]{ny, nx});
					}
				}
				if (cnt != 0)
					areas.add(cnt);
			}
		}
		areas.sort((a, b) -> Integer.compare(a, b));
		sb.append(areas.size() + "\n");
		for (var e : areas) {
			sb.append(e + "\n");
		}
		System.out.println(sb);
	}
}
