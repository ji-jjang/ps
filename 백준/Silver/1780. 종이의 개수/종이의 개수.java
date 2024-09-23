import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] ans = new int[3];
		recur(n, 0, 0, ans, board);
		for (int i = 0; i < 3; ++i) 
			System.out.println(ans[i]);
	}

	static void recur(int n, int r, int c, int[] ans, int[][] board) {

		if (checkSame(n, r, c, board)) {
			ans[board[r][c] + 1]++;
			return;
		}

		int nn = n / 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				recur(nn, r + i * nn, c + j * nn, ans, board);
			}
		}
	}

	static boolean checkSame(int n, int r, int c, int[][] board) {

		int st = board[r][c];
		for (int i = r; i < r + n; ++i) {
			for (int j = c; j < c + n; ++j) {
				if (board[i][j] != st) 
					return false;
			}
		}
		return true;
	}
}
