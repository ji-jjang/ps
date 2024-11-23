import java.io.*;
import java.util.*;

public class Main {

	static char[][] board;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		for (int i = 0; i < n; ++i) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < n; ++j) {
				board[i][j] = chars[j];
			}
		}

		StringBuilder sb = new StringBuilder();
		recur(n, 0, 0, sb);
		System.out.println(sb);
	}

	static void recur(int n, int r, int c, StringBuilder sb) {

		char color = board[r][c];

		if (isOneColor(n, r, c, color)) {
			sb.append(color);
			return;
		}
		int nn = n / 2;
		sb.append("(");
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				recur(nn, r + i * nn, c + j * nn, sb);
			}
		}
		sb.append(")");
	}
	static boolean isOneColor(int n, int r, int c, char color) {

		for (int i = r; i < r + n; ++ i) {
			for (int j = c; j < c + n; ++j) {
				if (board[i][j] != color) return false;
			}
		}
		return true;
	}
}
