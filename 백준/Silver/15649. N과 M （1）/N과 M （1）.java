import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);

		StringBuilder sb = new StringBuilder();
		dfs(0, 1, sb, new int[m], new boolean[n + 1]);
		System.out.println(sb);
	}

	static void dfs(int depth, int st, StringBuilder sb, int[] nums, boolean[] isVisited) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			nums[depth] = i;
			dfs(depth + 1, i + 1, sb, nums, isVisited);
			isVisited[i] = false;
		}
	}
}
