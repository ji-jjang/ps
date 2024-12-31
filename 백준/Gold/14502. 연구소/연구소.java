import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static int[][] map;
	static int[][] copy;
	static List<int[]> emptyList = new ArrayList<>();
	static List<int[]> virus = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		r = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);
		map = new int[r][c];
		copy = new int[r][c];

		for (int i = 0; i < r; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < c; ++j) {
				map[i][j] = Integer.parseInt(tokens[j]);

				if (map[i][j] == 0) {
					emptyList.add(new int[]{i, j});
				} else if (map[i][j] == 2) {
					virus.add(new int[]{i, j});
				}
			}
		}

		dfs(0, 0, new ArrayList<>());

		System.out.println(ans);
	}

	static void dfs(int depth, int st, List<int[]> selected) {
		
		if (depth == 3) {
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					copy[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < selected.size(); ++i) {
				int y = selected.get(i)[0];
				int x = selected.get(i)[1];
				copy[y][x] = 1;
			}

			Queue<int[]> q = new LinkedList<>();
			for (var e : virus) {
				q.offer(e);
			}
			while (!q.isEmpty()) {
				var cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (copy[ny][nx] != 0) continue;
					copy[ny][nx] = 2;
					q.offer(new int[]{ny, nx});
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (copy[i][j] == 0) ++cnt;
				}
			}
			ans = Math.max(ans, cnt);
			return; 
		}
		for (int i = st; i < emptyList.size(); ++i) {

			selected.add(emptyList.get(i));
			dfs(depth + 1, i + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}
}
