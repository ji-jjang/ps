import java.io.*;
import java.util.*;


public class Main {

	static char[][] map = new char[12][6];
	static int ans = 0;
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; ++i) {
			String line = br.readLine();
			for (int j = 0; j < 6; ++j) {
				map[i][j] = line.charAt(j);
			}
		}

		while (true) {
			if (!boom())
				break;
			pulldown();
			++ans;
		}
		System.out.println(ans);
	}

	public static boolean boom() {

		boolean[][] isVisited = new boolean[12][6];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> track = new LinkedList<>();

		boolean isBoomed = false;
		for (int i = 0; i < 12; ++i) {
			for (int j = 0; j < 6; ++j) {
				if (map[i][j] != '.' && !isVisited[i][j]) {
					char color = map[i][j];
					isVisited[i][j] = true;
					q.add(new int[]{i, j});
					track.add(new int[]{i, j});
					int cnt = 1;
					while (!q.isEmpty()) {

						var cur = q.poll();
						int y = cur[0];
						int x = cur[1];

						for (int dir = 0; dir < 4; ++dir) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];

							if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
							if (isVisited[ny][nx] || map[ny][nx] != color) continue;

							++cnt;
							track.add(new int[]{ny, nx});
							isVisited[ny][nx] = true;
							q.add(new int[]{ny, nx});
						}
					}
					if (cnt >= 4) {
						isBoomed = true;
						while (!track.isEmpty()) {
							var cur = track.poll();
							map[cur[0]][cur[1]] = '.';
						}
					}
					else
						track.clear();
				}
			}
		}
		return isBoomed;
	}
	public static void pulldown() {
		for (int col = 0; col < 6; ++col) {
			for (int row = 10; row >= 0; --row) {
				recur(row, col);
			}
		}
	}

	public static void recur(int row, int col) {

		if (row == 11 || map[row + 1][col] != '.')
			return;
		map[row + 1][col] = map[row][col];
		map[row][col] = '.';
		recur(row + 1, col);
	}
}
