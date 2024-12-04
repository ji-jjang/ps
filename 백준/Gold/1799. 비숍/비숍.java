import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] board;
	static List<int[]> pos1 = new ArrayList<>();
	static List<int[]> pos2 = new ArrayList<>();
	static boolean[] diag1 = new boolean[50];
	static boolean[] diag2 = new boolean[50];
	static int[] ans = new int[2];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; ++i) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(tokens[j]);
				if (board[i][j] == 1) {
					if ((i + j) % 2 == 0) {
						pos1.add(new int[]{i, j});
					} else {
						pos2.add(new int[]{i, j});
					}
				}
			}
		}
		dfs(0, 0, pos1, 0);
		dfs(0, 0, pos2, 1);
		System.out.println(ans[0] + ans[1]);
	}

	static void dfs(int depth, int count, List<int[]> pos, int idx) {

		if (depth == pos.size()) {
			ans[idx] = Math.max(ans[idx], count);
			return;
		}
		var cur = pos.get(depth);
		int row = cur[0];
		int col = cur[1];

		if (!diag1[row + col] && !diag2[row - col + n]) {
			diag1[row + col] = true;
			diag2[row - col + n] = true;
			dfs(depth + 1, count + 1, pos, idx);
			diag1[row + col] = false;
			diag2[row - col + n] = false;
		}
		dfs(depth + 1, count, pos, idx);
	}
}
