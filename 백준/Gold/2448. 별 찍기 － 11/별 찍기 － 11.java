import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void printStar(int r, int c, char[][] board) {

		board[r][c] = '*';
		board[r + 1][c - 1] = '*';
		board[r + 1][c + 1] = '*';
		for (int idx = 0; idx < 5; ++idx) {
			board[r + 2][c - 2 + idx] = '*';
		}
	}

	public static void recur(int r, int c, int h, char[][] board) {

		if (h == 3) {
			printStar(r, c, board);
			return;
		}
		int hh = h >> 1;

		recur(r, c, hh, board);
		recur(r + hh, c - hh, hh, board);
		recur(r + hh, c + hh, hh, board);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][2 * n - 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				board[i][j] = ' ';
			}
		}

		recur(0, n - 1, n, board);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}

