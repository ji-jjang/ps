import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] board;
	static int[][] copy;
	static int ans = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		copy = new int[n][n];
		for (int i = 0; i < n; ++i) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		dfs(0, new ArrayList<>());
		System.out.println(ans);
	}

	static void dfs(int depth, List<Integer> selected) {

		if (depth == 5) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					copy[i][j] = board[i][j];
				}
			}
			for (int i = 0; i < 5; ++i) {
				rotate(selected.get(i));
				push();
			}
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					ans = Math.max(ans, copy[i][j]);
				}
			}
			return; 
		}
		for (int i = 0; i < 4; ++i) {
			selected.add(i);
			dfs(depth + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}

	static void rotate(int dir) {

		while (dir-- > 0) {
			int[][] tmp = new int[n][n];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					tmp[j][n - i - 1] = copy[i][j];
				}
			}
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					copy[i][j] = tmp[i][j];
				}
			}
		}
	}

	static void push() {

		for (int row = 0; row < n; ++row) {
			int[] tmp = new int[n];
			int idx = 0;
			for (int col = 0; col < n; ++col) {
				if (copy[row][col] == 0) {
					continue;
				} 
				if (tmp[idx] == 0) {
					tmp[idx] = copy[row][col];
				}
				else if (tmp[idx] == copy[row][col]) {
					tmp[idx++] *= 2;
				}
				else if (tmp[idx] != copy[row][col]) {
					tmp[++idx] = copy[row][col];
				}
			}
			for (int i = 0; i < n; ++i) {
				copy[row][i] = tmp[i];
			}
		}
	}
}
