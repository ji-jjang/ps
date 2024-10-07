import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int ans = dfs(0, 0, 0, n, s, nums);
		if (s == 0) ans -= 1;
		System.out.println(ans);
	}

	public static int dfs(int depth, int sum, int cnt, int n, int s, int[] nums) {

		if (depth == n) return sum == s ? 1 : 0;

		int ans = 0;
		ans += dfs(depth + 1, sum + nums[depth], cnt + 1, n, s, nums);
		ans += dfs(depth + 1, sum, cnt, n, s, nums);
		return ans;
	}
}
