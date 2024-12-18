import java.util.*;
import java.io.*;

public class Main {

	static char[][] board = new char[12][6];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < 6; ++j) {
				board[i][j] = line[j];
			}
		}

		int ans = 0;
		while (true) {
			if (!isBoom()) {
				break;
			}
			++ans;
			pulldown();
		}
		System.out.println(ans);
	}

	static boolean isBoom() {

		boolean isBoom = false;
		boolean isVisited[][] = new boolean[12][6];

		List<int[]> nums = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < 12; ++i) {
			for (int j = 0; j < 6; ++j) {
				if (!isVisited[i][j] && board[i][j] != '.') {
					isVisited[i][j] = true;
					q.offer(new int[]{i, j});
					nums.add(new int[]{i, j});
				}
				char color = board[i][j];
				int cnt = 0;
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					++cnt;
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
						if (isVisited[ny][nx] || board[ny][nx] != color) continue;
						isVisited[ny][nx] = true;
						q.offer(new int[]{ny, nx});
						nums.add(new int[]{ny, nx});
					}
				}
				if (nums.size() >= 4) {
					isBoom = true;
					for (var e : nums) {
						board[e[0]][e[1]] = '.';
					}
				}
				nums.clear();
				q.clear();
			}
		}
		return isBoom;
	}

	static void pulldown() {

		for (int col = 0; col < 6; ++col) {
			for (int row = 11; row >= 0; --row) {
				recur(row, col);
			}
		}
	}

	static void recur(int row, int col) {

		if (row == 11 || board[row + 1][col] != '.')
			return;
		board[row + 1][col] = board[row][col];
		board[row][col] = '.';
		recur(row + 1, col);
	}
}
