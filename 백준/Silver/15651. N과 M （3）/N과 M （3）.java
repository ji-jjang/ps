import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[m + 1];
		StringBuilder sb = new StringBuilder();
		dfs(0, n, m, nums, sb);
		System.out.println(sb);
	}

	public static void dfs(int depth, int n, int m, int[] nums, StringBuilder sb) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; ++i) {
			nums[depth] = i;
			dfs(depth + 1, n, m, nums, sb);
		}
	}
}
