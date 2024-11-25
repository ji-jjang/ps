import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static char[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new char[n][n * 2];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(board[i], ' ');
		}

		recur(n, 0, n - 1);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n * 2; ++j) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void recur(int n, int r, int c) {
		if (n == 3) {
			board[r][c] = '*';
			board[r + 1][c - 1] = '*';
			board[r + 1][c + 1] = '*';
			for (int i = 0; i < 5; ++i) {
				board[r + 2][c - 2 + i] = '*';
			}
			return;
		}

		int nn = n / 2;

		recur(nn, r, c);
		recur(nn, r + nn, c - nn);
		recur(nn, r + nn, c + nn);
	}
}
