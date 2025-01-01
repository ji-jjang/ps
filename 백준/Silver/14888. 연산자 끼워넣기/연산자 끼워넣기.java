import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] nums; 
	static List<Integer> opers = new ArrayList<>();
	static int minValue = Integer.MAX_VALUE;
	static int maxValue = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		String[] tokens = br.readLine().split(" ");
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(tokens[i]);
		}
		tokens = br.readLine().split(" ");
		for (int i = 0; i < 4; ++i) {
			int num = Integer.parseInt(tokens[i]);
			for (int j = 0; j < num; ++j) {
				opers.add(i);
			}
		}

		dfs(0, new ArrayList<>(), new boolean[n - 1]);

		System.out.println(maxValue + "\n" + minValue);
	}

	static void dfs(int depth, List<Integer> selected, boolean[] isVisited) {
		if (depth == n - 1) {

			int ret = nums[0];
			for (int i = 1; i < n; ++i) {
				int op = selected.get(i - 1);
				if (op == 0) {
					ret += nums[i];
				}
				else if (op == 1) {
					ret -= nums[i];
				}
				else if (op == 2) {
					ret *= nums[i];
				}
				else {
					ret /= nums[i];
				}
			}
			minValue = Math.min(minValue, ret);
			maxValue = Math.max(maxValue, ret);
			return;
		}

		for (int i = 0; i < opers.size(); ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			selected.add(opers.get(i));
			dfs(depth + 1, selected, isVisited);
			isVisited[i] = false;
			selected.remove(selected.size() - 1);
		}
	}
}
