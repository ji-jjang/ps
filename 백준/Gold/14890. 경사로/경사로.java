import java.io.*;
import java.util.*;

public class Main {

	static int n, l;
	static int[][] map;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		l = Integer.parseInt(tokens[1]);
		map = new int[n][n];

		for (int i = 0; i < n; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (canCross(i))
				++ans;
		}
		rotate();
		for (int i = 0; i < n; ++i) {
			if (canCross(i))
				++ans;
		}
		System.out.println(ans);
	}

	static boolean canCross(int row) {

		boolean[] isChecked = new boolean[n];

		for (int col = 0; col < n - 1; ++col) {
			if (map[row][col] == map[row][col + 1]) continue;

			if (Math.abs(map[row][col] - map[row][col + 1]) > 1) return false;

			if (map[row][col] > map[row][col + 1]) {
				for (int i = 1; i <= l; ++i) {
					if (col + i >= n || map[row][col + 1] != map[row][col + i] || isChecked[col + i]) {
						return false;
					}
					isChecked[col + i] = true; 
				}
			} else {
				for (int i = 0; i < l; ++i) {
					if (col - i < 0 || map[row][col] != map[row][col - i] || isChecked[col - i]) {
						return false;
					}
					isChecked[col - i] = true;
				}
			}
		}
		return true;
	}


	static void rotate() {
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				map[j][n - i - 1] = tmp[i][j];
			}
		}
	}
}
