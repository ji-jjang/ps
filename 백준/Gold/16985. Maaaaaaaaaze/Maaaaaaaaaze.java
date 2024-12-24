import java.util.*;
import java.io.*;

public class Main {

	static int[][][] origin = new int[5][5][5];
	static int[][][] board = new int[5][5][5];
	static int ans = Integer.MAX_VALUE;
	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				String[] tokens = br.readLine().split(" ");
				for (int k = 0; k < 5; ++k) {
					origin[i][j][k] = Integer.parseInt(tokens[k]);
				}
			}
		}
		dfs(0, new ArrayList<>(), new boolean[5]);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}

	static void dfs(int depth, List<Integer> nums, boolean[] isVisited) {
		if (depth == 5) {
			dfs2(0, new ArrayList<>(), nums);
			return;
		}
		for (int i = 0; i < 5; ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			nums.add(i);
			dfs(depth + 1, nums, isVisited);
			isVisited[i] = false;
			nums.remove(nums.size() - 1);
		}
	}

	static void dfs2(int depth, List<Integer> dirs, List<Integer> nums) {

		if (depth == 5) {
			
			for (int i = 0; i < 5; ++i) {
				int idx = nums.get(i);
				for (int j = 0; j < 5; ++j) {
					for (int k = 0; k < 5; ++k) {
						board[i][j][k] = origin[idx][j][k];
					}
				}
			}
			for (int i = 0; i < 5; ++i) {
				rotate(i, dirs.get(i));
			}
			ans = Math.min(ans, bfs());
			return;
		}
		for (int i = 0; i < 4; ++i) {
			dirs.add(i);
			dfs2(depth + 1, dirs, nums);
			dirs.remove(dirs.size() - 1);
		}
	}

	static void rotate(int idx, int dir) {

		while (dir-- > 0) {
			int[][] tmp = new int[5][5];
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					tmp[i][j] = board[idx][i][j];
				}
			}

			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					board[idx][j][5 - i - 1] = tmp[i][j];
				}
			}
		}
	}
	
	static int bfs() {

		if (board[0][0][0] == 0 || board[4][4][4] == 0) {
			return Integer.MAX_VALUE;
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] isVisited = new boolean[5][5][5];
		q.add(new int[]{0, 0, 0, 0}); // z, y, x, cnt
		while (!q.isEmpty()) {
			var cur = q.poll();
			int z = cur[0];
			int y = cur[1];
			int x = cur[2];
			int cnt = cur[3];
			if (cnt == ans) 
				return cnt;
			if (z == 4 && y == 4 && x == 4) {
				return cnt;
			}
			for (int dir = 0; dir < 6; ++dir) {
				int nz = z + dz[dir];
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;
				if (isVisited[nz][ny][nx] || board[nz][ny][nx] != 1) continue;
				isVisited[nz][ny][nx] = true;
				q.add(new int[]{nz, ny, nx, cnt + 1});
			}
		}
		return Integer.MAX_VALUE;
	}
}
