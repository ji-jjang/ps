import java.io.*;
import java.util.*;

public class Main {

	static int[] nums;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] tokens = br.readLine().split(" ");

			n = Integer.parseInt(tokens[0]);

			if (n == 0) break;

			nums = new int[n];

			for (int i = 0; i < n; ++i) {
				nums[i] = Integer.parseInt(tokens[i + 1]);
			}
			dfs(0, 0, new int[n], sb);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth, int st, int[] selected, StringBuilder sb) {

		if (depth == 6) {
			for (int i = 0; i < 6; ++i) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = st; i < n; ++i) {
			selected[depth] = nums[i];
			dfs(depth + 1, i + 1, selected, sb);
		}
	}
}
