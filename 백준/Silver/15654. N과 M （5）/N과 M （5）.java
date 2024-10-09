import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		boolean[] isSelected = new boolean[n];
		int[] seq = new int[m + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		StringBuilder sb = new StringBuilder();
		dfs(0, n, m, nums, seq, sb, isSelected);
		System.out.println(sb);
	}

	public static void dfs(int depth, int n, int m, int[] nums, int[] seq, StringBuilder sb, boolean[] isSelected) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(seq[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			seq[depth] = nums[i];
			dfs(depth + 1, n, m, nums, seq, sb, isSelected);
			isSelected[i] = false;
		}
	}
}
