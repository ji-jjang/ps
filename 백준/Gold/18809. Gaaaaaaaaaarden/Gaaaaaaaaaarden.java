import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans = 0;
	static int[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int green = Integer.parseInt(st.nextToken());
		int red = Integer.parseInt(st.nextToken());

		board = new int[r][c];
		List<int[]> pos = new ArrayList<>();

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					pos.add(new int[]{i, j});
				}
			}
		}
		int[] color = new int[pos.size()];
		dfs(0, r, c, green, red, color, pos);
		System.out.println(ans);
	}

	public static void dfs(int depth, int r, int c, int green, int red, int[] color, List<int[]> pos) {

		if (green + red == 0) {
			bfs(r, c, color, pos);
			return;
		}

		if (depth == pos.size())
			return;

		if (green > 0) {
			color[depth] = 2;
			dfs(depth + 1, r, c, green - 1, red, color, pos);
			color[depth] = 0;
		}

		if (red > 0) {
			color[depth] = 1;
			dfs(depth + 1, r, c, green, red - 1, color, pos);
			color[depth] = 0;
		}
		dfs(depth + 1, r, c, green, red, color, pos);
	}

	public static void bfs(int r, int c, int[] color, List<int[]> pos) {

		Queue<int[]> q = new LinkedList<>(); // y, x, time, color
		int[][] greenMap = new int[r][c];
		int[][] redMap = new int[r][c];
		boolean[][] flower = new boolean[r][c];

		for (int[] row : greenMap) Arrays.fill(row, -1);
		for (int[] row : redMap) Arrays.fill(row, -1);

		for (int i = 0; i < color.length; ++i) {
			int y = pos.get(i)[0];
			int x = pos.get(i)[1];
			if (color[i] == 2) {
				greenMap[y][x] = 0;
				q.add(new int[]{y, x, 0, 2}); 
			} else if (color[i] == 1) {
				redMap[y][x] = 0;
				q.add(new int[]{y, x, 0, 1});
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int time = cur[2];
			int type = cur[3];

			if (flower[y][x]) continue;

			if (greenMap[y][x] == redMap[y][x] && greenMap[y][x] != -1) {
				flower[y][x] = true;
				++cnt;
				continue;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] == 0 || flower[ny][nx]) continue;

				if (type == 2) {
					if (greenMap[ny][nx] == -1) {
						greenMap[ny][nx] = time + 1;
						if (redMap[ny][nx] != -1 && redMap[ny][nx] == time + 1) {
							flower[ny][nx] = true;
							cnt++;
						} else {
							q.add(new int[]{ny, nx, time + 1, 2});
						}
					}
				} else if (type == 1) {
					if (redMap[ny][nx] == -1) {
						redMap[ny][nx] = time + 1;
						if (greenMap[ny][nx] != -1 && greenMap[ny][nx] == time + 1) {
							flower[ny][nx] = true;
							cnt++;
						} else {
							q.add(new int[]{ny, nx, time + 1, 1});
						}
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
}
