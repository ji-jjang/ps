import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] nums;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);
		nums = new int[n];

		tokens = br.readLine().split(" ");
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(tokens[i]);
		}
		Arrays.sort(nums);

		StringBuilder sb = new StringBuilder();
		dfs(0, new int[n + 1], new boolean[n + 1], sb);
		System.out.println(sb);
	}

	static void dfs(int depth, int[] selected, boolean[] isVisited, StringBuilder sb) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			selected[depth] = nums[i];
			dfs(depth + 1, selected, isVisited, sb);
			isVisited[i] = false;
		}
	}
}
