import java.util.*;
import java.io.*;

public class Main {

	static int r, c;
	static int[][] board;
	static int[][] cBoard;
	static List<int[]> cctv = new LinkedList<>();
	static int[][][] cctvDirs = {
		{},
		{{0}, {1}, {2}, {3}},
		{{0, 2}, {1, 3}},
		{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
		{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
		{{0, 1, 2, 3}}
	};
	static List<List<Integer>> seq = new ArrayList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		r = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);
		board = new int[r][c];
		cBoard = new int[r][c];

		for (int i = 0; i < r; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(tokens[j]);
				if (board[i][j] >= 1 && board[i][j] <= 5) {
					cctv.add(new int[]{i, j});
				}
			}
		}
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int depth) {


		if (depth == cctv.size()) {

			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					cBoard[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < seq.size(); ++i) {
				for (var dir : seq.get(i)) {
					watchArea(cctv.get(i)[0], cctv.get(i)[1], dir);
				}
			}
			int cnt = 0;
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (cBoard[i][j] == 0)
						++cnt;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		int type = board[cctv.get(depth)[0]][cctv.get(depth)[1]];
		for (var dir : cctvDirs[type]) {
			List<Integer> dirs = new ArrayList<>();
			for (var e : dir)
				dirs.add(e);
			seq.add(dirs);
			dfs(depth + 1);
			seq.remove(seq.size() - 1);
		}
	}

	static void watchArea(int y, int x, Integer dir) {

		while (true) {
			y += dy[dir];
			x += dx[dir];
			if (y < 0 || y >= r || x < 0 || x >= c)
				break;
			if (cBoard[y][x] == 6)
				break;
			if (cBoard[y][x] >= 1 && cBoard[y][x] <= 5)
				continue;
			cBoard[y][x] = 9;
		}
	}
}
