import java.io.*;
import java.util.*;

public class Main {

	static int[] ans = new int[4];
	static int[][] board;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		recur(n, 0, 0);
		System.out.println(ans[0] + "\n" + ans[1] + "\n" + ans[2]);
	}

	static void recur(int n, int r, int c) {

		int color = board[r][c];

		if (isOneColor(n, r, c, color)) {
			ans[color + 1]++;
			return;
		}
		int nn = n / 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				recur(nn, r + i * nn, c + j * nn);
			}
		}
	}
	static boolean isOneColor(int n, int r, int c, int color) {

		for (int i = r; i < r + n; ++ i) {
			for (int j = c; j < c + n; ++j) {
				if (board[i][j] != color) return false;
			}
		}
		return true;
	}
}
