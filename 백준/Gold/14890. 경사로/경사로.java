import java.io.*;
import java.util.*;

public class Main {

	static int n, l;
	static int[][] map;
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; ++i) {
			if (canPassWay(i)) {
				++ans;
			}
		}

		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				tmp[j][n - i - 1] = map[i][j];
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				map[i][j] = tmp[i][j];
			}
		}
		for (int i = 0; i < n; ++i) {
			if (canPassWay(i)) {
				++ans;
			}
		}
		System.out.println(ans);
	}

	static boolean canPassWay(int row) {

		boolean[] isUsed = new boolean[n];
		for (int col = 0; col < n - 1; ++col) {
			int cur = map[row][col];
			int nxt = map[row][col + 1];
			if (cur == nxt)
				continue;
			if (Math.abs(cur - nxt) != 1)
				return false;

			if (cur + 1 == nxt) {
				for (int i = col; i >= col - l + 1; --i) {
					if (i < 0 || map[row][i] != cur || isUsed[i])
						return false;
					isUsed[i] = true;
				}
			}
			else if (cur - 1 == nxt) { 
				for (int i = col + 1; i <= col + l; ++i) {
					if (i >= n || map[row][i] != nxt || isUsed[i])
						return false;
					isUsed[i] = true;
				}
			}
		}
		return true;
	}
}
