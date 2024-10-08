import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[m + 1];
		boolean[] isSelected = new boolean[n + 1];

		dfs(0, 1, n, m, nums, isSelected);
	}

	public static void dfs(int depth, int st, int n, int m, int[] nums, boolean[] isSelected) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				System.out.printf(nums[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = st; i <= n; ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			nums[depth] = i;
			dfs(depth + 1, i + 1, n, m, nums, isSelected);
			isSelected[i] = false;
		}
	}
}
