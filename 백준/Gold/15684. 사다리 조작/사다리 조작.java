import java.io.*;
import java.util.*;

public class Main {
	static int c, m, r;
	static int[][] lad;
	static ArrayList<int[]> emp = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		lad = new int[r + 2][c + 2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lad[a][b] = 1;
			lad[a][b + 1] = 2;
		}
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j < c; ++j) {
				if (lad[i][j] == 0 && lad[i][j + 1] == 0)
					emp.add(new int[]{i, j});
			}
		}
		for (int i = 0; i <= 3; i++) {
			dfs(0, i, 0);
			if (ans != Integer.MAX_VALUE)
				break;
		}
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void dfs(int depth, int mx, int start) {
		if (depth == mx) {
			if (isStraight())
				ans = Math.min(ans, depth);
			return;
		}
		for (int i = start; i < emp.size(); ++i) {
			int[] cur = emp.get(i);
			if (lad[cur[0]][cur[1]] != 0 || lad[cur[0]][cur[1] + 1] != 0)
				continue;
			lad[cur[0]][cur[1]] = 1;
			lad[cur[0]][cur[1] + 1] = 2;
			dfs(depth + 1, mx, i + 1);
			lad[cur[0]][cur[1]] = 0;
			lad[cur[0]][cur[1] + 1] = 0;
		}
	}

	static boolean isStraight() {
		for (int col = 1; col <= c; ++col) {
			int sCol = col;
			int row = 0;
			while (row <= r) {
				if (lad[row][col] == 1)
					++col;
				else if (lad[row][col] == 2)
					--col;
				++row;
			}
			if (sCol != col)
				return false;
		}
		return true;
	}
}


