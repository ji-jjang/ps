import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<int[]> eggs = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int strength = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs.add(new int[]{strength, weight});
		}

		int ans = dfs(0, n, eggs);
		System.out.println(ans);
	}

	public static int dfs(int depth, int n, List<int[]> eggs) {

		if (depth == n) {
			int cnt = 0;
			for (int i = 0; i < n; ++i) {
				if (eggs.get(i)[0] <= 0) {
					++cnt;
				}
			}
			return cnt;
		}

		if (eggs.get(depth)[0] <= 0 || !isRemain(depth, eggs)) {
			return dfs(depth + 1, n, eggs);
		}

		int ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i == depth || eggs.get(i)[0] <= 0) continue;
			eggs.get(depth)[0] -= eggs.get(i)[1];
			eggs.get(i)[0] -= eggs.get(depth)[1];
			int cnt = dfs(depth + 1, n, eggs);
			ans = Math.max(ans, cnt);
			eggs.get(depth)[0] += eggs.get(i)[1];
			eggs.get(i)[0] += eggs.get(depth)[1];
		}
		return ans;
	}

	public static boolean isRemain(int depth, List<int[]> eggs) {

		for (int i = 0; i < eggs.size(); ++i) {
			if (i != depth && eggs.get(i)[0] > 0)
				return true;
		}
		return false;
	}
}

