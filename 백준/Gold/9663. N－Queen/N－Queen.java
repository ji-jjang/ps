import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[] col = new boolean[15];
		boolean[] diag1 = new boolean[50];
		boolean[] diag2 = new boolean[50];

		int ans = dfs(0, n, col, diag1, diag2);
		System.out.println(ans);
	}

	static int dfs(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2) {

		if (row == n) {
			return 1;
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (col[i] || diag1[i + row] || diag2[row - i + n - 1])
				continue;
			col[i] = true;
			diag1[i + row] = true;
			diag2[row - i + n - 1] = true;
			ans += dfs(row + 1, n, col, diag1, diag2);
			col[i] = false;
			diag1[i + row] = false;
			diag2[row - i + n - 1] = false;
		}
		return ans;
	}
}
