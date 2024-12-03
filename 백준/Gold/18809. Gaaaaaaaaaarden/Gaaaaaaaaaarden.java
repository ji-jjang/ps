import java.util.*;
import java.io.*;

public class Main {

	static int r, c;
	static int gr, re;
	static int[][] garden;
	static List<int[]> pos = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		r = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);
		gr = Integer.parseInt(tokens[2]);
		re = Integer.parseInt(tokens[3]);
		garden = new int[r][c];


		for (int i = 0; i < r; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < c; ++j) {
				garden[i][j] = Integer.parseInt(tokens[j]);
				if (garden[i][j] == 2) {
					pos.add(new int[]{i, j});
				}
			}
		}
		dfs(0, new ArrayList<>(), new ArrayList<>());
		System.out.println(ans);
	}

	static void dfs(int depth, List<int[]> green, List<int[]> red) {

		if (green.size() == gr && red.size() == re) {
			ans = Math.max(ans, bfs(green, red));
			return;
		}

		if (depth >= pos.size()) {
			return;
		}

		var cur = pos.get(depth);

		if (green.size() < gr) {
			green.add(cur);
			dfs(depth + 1, green, red);
			green.remove(green.size() - 1);
		}
		if (red.size() < re) {
			red.add(cur);
			dfs(depth + 1, green, red);
			red.remove(red.size() - 1);
		}
		dfs(depth + 1, green, red);
	}

	static int bfs(List<int[]> green, List<int[]> red) {

		int[][] dist1 = new int[r][c];
		int[][] dist2 = new int[r][c];
		boolean[][] flower = new boolean[r][c];

		for (int i = 0; i < r; ++i) {
			Arrays.fill(dist1[i], -1);
			Arrays.fill(dist2[i], -1);
		}
		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();

		for (var e : green) {
			dist1[e[0]][e[1]] = 0;
			q1.add(e);
		}

		for (var e : red) {
			dist2[e[0]][e[1]] = 0;
			q2.add(e);
		}

		int cnt = 0;
		while (!q1.isEmpty() || !q2.isEmpty()) {

			int size = q1.size();
			for (int i = 0; i < size; ++i) {

				var cur = q1.poll();
				int y = cur[0];
				int x = cur[1];

				if (flower[y][x]) continue;

				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

					if (dist1[ny][nx] != -1 || garden[ny][nx] == 0) continue;

					if (!flower[ny][nx] && dist2[ny][nx] != -1 && dist2[ny][nx] == dist1[y][x] + 1) {
						flower[ny][nx] = true;
						++cnt;
						continue;
					}

					dist1[ny][nx] = dist1[y][x] + 1;
					q1.add(new int[]{ny, nx});
				}
			}
			size = q2.size();
			for (int i = 0; i < size; ++i) {
				var cur = q2.poll();
				int y = cur[0];
				int x = cur[1];

				if (flower[y][x]) 
					continue;

				for (int dir = 0; dir < 4; ++dir) {

					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (garden[ny][nx] == 0 || dist2[ny][nx] != -1) continue;
					if (!flower[ny][nx] && dist1[ny][nx] != -1 && dist1[ny][nx] == dist2[y][x] + 1) {
						flower[ny][nx] = true;
						++cnt;
						continue;
					}

					dist2[ny][nx] = dist2[y][x] + 1;
					q2.add(new int[]{ny, nx});
				}
			}
		}
		return cnt;
	}
}
