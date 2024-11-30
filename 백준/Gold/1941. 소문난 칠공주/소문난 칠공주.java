import java.util.*;

public class Main {

	static char[][] grid = new char[5][5];
	static boolean[][] isVisited = new boolean[5][5];
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			grid[i] = sc.next().toCharArray();
		}

		List<int[]> points = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				points.add(new int[]{i, j});
			}
		}
		dfs(0, 0, points, new ArrayList<>());
		System.out.println(ans);
	}

	static void dfs(int depth, int st, List<int[]> points, List<int[]> selected) {

		if (depth == 7) {
			if (isValid(selected)) ++ans;
			return;
		}

		for (int i = st; i < points.size(); i++) {
			selected.add(points.get(i));
			dfs(depth + 1, i + 1, points, selected);
			selected.remove(selected.size() - 1);
		}
	}

	static boolean isValid(List<int[]> selected) {

		int sCnt = 0;
		for (var e : selected) {
			if (grid[e[0]][e[1]] == 'S') ++sCnt;
		}
		if (sCnt < 4) return false;

		return isConnected(selected);
	}

	static boolean isConnected(List<int[]> selected) {

		boolean[][] isChecked = new boolean[5][5];
		for (var pos : selected) {
			isChecked[pos[0]][pos[1]] = true;
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(selected.get(0));
		boolean[][] isChecked2 = new boolean[5][5];
		isChecked2[selected.get(0)[0]][selected.get(0)[1]] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			++cnt;

			for (int dir = 0; dir < 4; ++dir) {
				int ny = cur[0] + dy[dir];
				int nx = cur[1] + dx[dir];
				if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
				if (isChecked2[ny][nx]) continue;
				if (!isChecked[ny][nx]) continue;
				isChecked2[ny][nx] = true;
				q.add(new int[]{ny, nx});
			}
		}

		return cnt == 7;
	}
}

