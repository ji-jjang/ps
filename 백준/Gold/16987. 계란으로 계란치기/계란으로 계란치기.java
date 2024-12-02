import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] eggs;
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		eggs = new int[n][2];
		for (int i = 0; i < n; ++i) {
			int dur, weight;
			String[] tokens = br.readLine().split(" ");
			dur = Integer.parseInt(tokens[0]);
			weight = Integer.parseInt(tokens[1]);
			eggs[i] = new int[]{dur, weight};
		}
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int depth) {

		if (depth == n) {
			int cnt = 0;
			for (int i = 0; i < n; ++i) {
				if (eggs[i][0] <= 0) ++cnt;
			}
			ans = Math.max(ans, cnt);
			return;
		}

		if (eggs[depth][0] <= 0 || !isRemain(depth)) {
			dfs(depth + 1);
			return;
		}

		for (int i = 0; i < n; ++i) {
			if (i == depth || eggs[i][0] <= 0) continue;
			eggs[depth][0] -= eggs[i][1];
			eggs[i][0] -= eggs[depth][1];
			dfs(depth + 1);
			eggs[depth][0] += eggs[i][1];
			eggs[i][0] += eggs[depth][1];
		}
	}

	static boolean isRemain(int depth) {
		for (int i = 0; i < n; ++i) {
			if (i != depth && eggs[i][0] > 0) 
				return true;
		}
		return false;
	}
}
