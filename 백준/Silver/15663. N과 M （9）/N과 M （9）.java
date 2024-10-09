import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		int[] seq = new int[m + 1];
		boolean[] isSelected = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		StringBuilder sb = new StringBuilder();
		Set<String> hs = new LinkedHashSet<>(); 
		dfs(0, n, m, nums, seq, sb, isSelected, hs);
		Iterator<String> it = hs.iterator();
		sb.setLength(0);
		while (it.hasNext()) {
			sb.append(it.next());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int depth, int n, int m, int[] nums, int[] seq, StringBuilder sb, boolean[] isSelected, Set<String> hs) {

		if (depth == m) {
			for (int i = 0; i < m; ++i) {
				sb.append(seq[i] + " ");
			}
			hs.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			seq[depth] = nums[i];
			dfs(depth + 1, n, m, nums, seq, sb, isSelected, hs);
			isSelected[i] = false;
		}
	}
}
