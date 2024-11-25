import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static char[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(board[i], '*');
		}

		recur(n, 0, 0);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void recur(int n, int r, int c) {
		if (n == 1)
			return;
		int nn = n / 3;

		for (int i = r + nn; i < r + 2 * nn; ++i) {
			for (int j = c + nn; j < c + 2 * nn; ++j) {
				board[i][j] = ' ';
			}
		}

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				recur(nn, r + nn * i, c + nn * j);
			}
		}
	}
}
