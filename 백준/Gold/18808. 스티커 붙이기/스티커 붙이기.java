import java.util.*;
import java.io.*;

public class Main {

	static int n, m, k;
	static int r, c;
	static int[][] sticker;
	static int[][] board;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);
		k = Integer.parseInt(tokens[2]);

		board = new int[44][44];
		for (int s = 0; s < k; ++s) {
			tokens = br.readLine().split(" ");
			r = Integer.parseInt(tokens[0]);
			c = Integer.parseInt(tokens[1]);

			sticker = new int[14][14];
			for (int i = 0; i < r; i++) {
				tokens = br.readLine().split(" ");
				for (int j = 0; j < c; j++) {
					sticker[i][j] = Integer.parseInt(tokens[j]);
				}
			}
			boolean canPut = false;
			for (int dir = 0; dir < 4; ++dir) {
				if (canPut) break;
				rotateSticker(dir);
				for (int i = 0; i <= n - r; ++i) {
					if (canPut) break;
					for (int j = 0; j <= m - c; ++j) {
						if (canPutSticker(i, j)) {
							canPut = true;
							break;
						}
					}
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (board[i][j] == 1)
					++ans;
			}
		}
		System.out.println(ans);
	}

	static void rotateSticker(int dir) {
        
		if (dir == 0) {
			return;
		}
		int[][] tmp = new int[14][14];
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				tmp[j][r - i - 1] = sticker[i][j];
			}
		}
		int temp = r;
		r = c;
		c = temp;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				sticker[i][j] = tmp[i][j];
			}
		}
	}

	static boolean canPutSticker(int y, int x) {

		for (int i = y; i < y + r; ++i) {
			for (int j = x; j < x + c; ++j) {
				if (board[i][j] == 1 && sticker[i - y][j - x] == 1) {
					return false;
				}
			}
		}
		for (int i = y; i < y + r; ++i) {
			for (int j = x; j < x + c; ++j) {
				if (board[i][j] == 0) {
					board[i][j] = sticker[i - y][j - x];
				}
			}
		}
		return true;
	}
}
