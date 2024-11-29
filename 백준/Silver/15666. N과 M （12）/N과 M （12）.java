import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] nums;
	static Set<String> set = new LinkedHashSet<>();
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

		dfs(0, new int[n + 1]);
		StringBuilder sb = new StringBuilder();
		for (var e : set) {
			sb.append(e + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int[] selected) {

		if (depth == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; ++i) {
				sb.append(selected[i] + " ");
			}
			set.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (depth != 0 && selected[depth - 1] > nums[i]) continue;
			selected[depth] = nums[i];
			dfs(depth + 1, selected);
		}
	}
}
