import java.io.*;
import java.util.*;

public class Main {

	static boolean[] diag1Check = new boolean[50];
	static boolean[] diag2Check = new boolean[50];
	static boolean[] colCheck = new boolean[15];
	static int n;
	static int ans = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int row) {

		if (row == n) {
			++ans;
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (colCheck[i] || diag1Check[i + row] || diag2Check[n + row - i])
				continue;
			colCheck[i] = true;
			diag1Check[i + row] = true;
			diag2Check[n - i + row] = true;
			dfs(row + 1);
			colCheck[i] = false;
			diag1Check[i + row] = false;
			diag2Check[n - i + row] = false;
		}
	}
}
