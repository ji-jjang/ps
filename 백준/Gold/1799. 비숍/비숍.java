import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		List<int[]> black = new ArrayList<>();
		List<int[]> white = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					if ((i + j) % 2 == 0) black.add(new int[]{i, j});
					else white.add(new int[]{i, j});
				}
			}
		}

		boolean[] diag1 = new boolean[50];
		boolean[] diag2 = new boolean[50];

		int ansBlack = dfs(0, 0, n, diag1, diag2, board, black);
		int ansWhite = dfs(0, 0, n, diag1, diag2, board, white);
		System.out.println(ansBlack + ansWhite);
	}

	public static int dfs(int depth, int cnt, int n, boolean[] diag1, boolean[] diag2, int[][] board, List<int[]> pos) {

		if (depth == pos.size()) return cnt;

		var cur = pos.get(depth);
		int row = cur[0];
		int col = cur[1];

		int maxCnt = cnt;
		if (!diag1[row + col] && !diag2[row - col + n - 1]) {
			diag1[row + col] = true;
			diag2[row - col + n - 1] = true;

			maxCnt = Math.max(maxCnt, dfs(depth + 1, cnt + 1, n, diag1, diag2, board, pos));

			diag1[row + col] = false;
			diag2[row - col + n - 1] = false;
		}
		maxCnt = Math.max(maxCnt, dfs(depth + 1, cnt, n, diag1, diag2, board, pos));

		return maxCnt;
	}
}
