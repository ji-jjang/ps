import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static List<int[]> empty = new ArrayList<>();
	static List<int[]> virus = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					empty.add(new int[]{i, j});
				}
				if (map[i][j] == 2) {
					virus.add(new int[]{i, j});
				}
			}
		}

		dfs(0, 0, new int[empty.size()]);
		System.out.println(ans);
	}

	public static void dfs(int depth, int st, int[] seq) {

		if (depth == 3) {
			bfs(seq);
			return; 
		}

		for (int i = st; i < empty.size(); ++i) {
			seq[depth] = i;
			dfs(depth + 1, i + 1, seq);
		}
	}

	public static void bfs(int[] seq) {

		int[][] tmp = new int[r][c];
		boolean[][] isVisited = new boolean[r][c];
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 3; ++i) {
			int idx = seq[i];
			tmp[empty.get(idx)[0]][empty.get(idx)[1]] = 1;
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); ++i) {
			q.add(new int[]{virus.get(i)[0], virus.get(i)[1]});
			isVisited[virus.get(i)[0]][virus.get(i)[1]] = true;
		}

		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (isVisited[ny][nx] || tmp[ny][nx] != 0) continue;
				isVisited[ny][nx] = true;
				tmp[ny][nx] = 2;
				q.add(new int[]{ny, nx});
			}
		}
		int cnt = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (tmp[i][j] == 0)
					++cnt;
			}
		}
		ans = Math.max(ans, cnt);
	}
}
