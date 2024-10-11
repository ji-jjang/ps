import java.io.*;
import java.util.*;


public class Main {

	static int[][] board;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];
		int[][] origin = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] sdir = new int[5];
		int ans = 0;
		for (int i = 0; i < (1 << (2 * 5)); ++i) {

			for (int j = 0; j < n; ++j) {
				board[j] = origin[j].clone();
			}

			int cur = i;
			for (int j = 0; j < 5; ++j) {
				sdir[j] = cur % 4;
				cur /= 4;
			}
			for (int k = 0; k < 5; ++k) {
				compress(sdir[k]);
			}
			for (int j = 0; j < n; ++j) {
				for (int k = 0; k < n; ++k) {
					ans = Math.max(ans, board[j][k]);
				}
			}
		}

		System.out.println(ans);
	}

	public static void compress(int cnt) {
		while (cnt-- != 0) {
			rotate();
		}
		comp();
	}

	public static void rotate() {

		int[][] tmp = new int[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				tmp[j][n - i - 1] = board[i][j];
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = tmp[i][j];
			}
		}
	}

	// push dir <-
	public static void comp() { 
		for (int row = 0; row < n; ++row) {
			int[] tmp = new int[n];
			int idx = 0;
			for (int col = 0; col < n; ++col) {
				if (board[row][col] == 0)
					continue;
				if (tmp[idx] == 0) {
					tmp[idx] = board[row][col];
					continue;
				}
				if (board[row][col] == tmp[idx])
					tmp[idx++] *= 2;
				else if (board[row][col] != tmp[idx])
					tmp[++idx] = board[row][col];
			}
			for (int i = 0; i < n; ++i) {
				board[row][i] = tmp[i];
			}
		}
	}
}
