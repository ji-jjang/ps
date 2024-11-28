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
		dfs(0, new int[n + 1], sb);
		System.out.println(sb);
	}

	static void dfs(int depth, int[] nums, StringBuilder sb) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; ++i) {
			nums[depth] = i;
			dfs(depth + 1, nums, sb);
		}
	}
}
