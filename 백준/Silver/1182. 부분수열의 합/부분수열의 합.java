import java.io.*;
import java.util.*;

public class Main {

	static int n, s;
	static int[] nums;
	static int ans;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		n = Integer.parseInt(tokens[0]);
		s = Integer.parseInt(tokens[1]);

		nums = new int[n];
		tokens = br.readLine().split(" ");
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(tokens[i]);
		}

		dfs(0, 0);
		if (s == 0) --ans;
		System.out.println(ans);
	}

	static void dfs(int depth, int sum) {
		
		if (depth == n) {
			if (sum == s) {
				++ans;
			}
			return;
		}
		dfs(depth + 1, sum + nums[depth]);
		dfs(depth + 1, sum);
	}
}
