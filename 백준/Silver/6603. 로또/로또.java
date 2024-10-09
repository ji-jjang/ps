import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			int[] nums = new int[n];
			int[] seq = new int[6];
			boolean[] isSelected = new boolean[n];
			for (int i = 0; i < n; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, n, nums, seq, sb, isSelected);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int depth, int st, int n, int[] nums, int[] seq, StringBuilder sb, boolean[] isSelected) {

		if (depth == 6) {
			for (int i = 0; i < 6; ++i) {
				sb.append(seq[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = st; i < n; ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			seq[depth] = nums[i];
			dfs(depth + 1, i + 1, n, nums, seq, sb, isSelected);
			isSelected[i] = false;
		}
	}
}
