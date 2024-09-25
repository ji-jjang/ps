import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		char[][] board = new char[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = '*';
			}
		}
		recur(n, 0, 0, board);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void recur(int n, int r, int c, char[][] board) {

		if (n == 3) {
			for (int i = r; i < r + 3; ++i) {
				for (int j = c; j < c + 3; ++j) {
					if (i % 3 == 1 && j % 3 == 1) {
						board[i][j] = ' ';
					}
				}
			}
			return;
		}

		int nn = n / 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (i == 1 && j == 1) {
					fillSpace(nn, r + i * nn, c + j * nn, board);
				}
				recur(nn, r + i * nn, c + j * nn, board);
			}
		}
	}

	static void fillSpace(int n, int r, int c, char[][] board) {

		for (int i = r; i < r + n; ++i) {
			for (int j = c; j < c + n; ++j) {
				board[i][j] = ' ';
			}
		}
	}
}
