import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];

		for (int i = 0; i < n; ++i) {
			String line = br.readLine();
			for (int j = 0; j < n; ++j) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		StringBuilder sb = new StringBuilder();
		recur(n, 0, 0, sb, board);
		System.out.println(sb);
	}

	static void recur(int n, int r, int c, StringBuilder sb, int[][] board) {

		if (checkSame(n, r, c, sb, board)) {
			sb.append(board[r][c]);
			return;
		}

		int nn = n / 2;
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				recur(nn, r + i * nn, c + j * nn, sb, board);
			}
		}
		sb.append(")");
	}

	static boolean checkSame(int n, int r, int c, StringBuilder sb,  int[][] board) {

		int st = board[r][c];
		for (int i = r; i < r + n; ++i) {
			for (int j = c; j < c + n; ++j) {
				if (board[i][j] != st) {
					sb.append("(");
					return false;
				}
			}
		}
		return true;
	}
}
