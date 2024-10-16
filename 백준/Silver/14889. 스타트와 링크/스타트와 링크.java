import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] team;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		team = new int[n][n];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, n, new int[n / 2], new boolean[n]);
		System.out.println(ans);
	}

	public static void dfs(int depth, int st, int n, int[] seq, boolean[] isVisited) {

		if (depth == n / 2) {
			int[] seq2 = new int[n / 2];
			int idx = 0;
			for (int i = 0; i < n; ++i) {
				if (!isVisited[i])
					seq2[idx++] = i;
			}
			ans = Math.min(ans, Math.abs(calTeam(seq) - calTeam(seq2)));
			return;
		}

		for (int i = st; i < n; ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			seq[depth] = i;
			dfs(depth + 1, i + 1, n, seq, isVisited);
			isVisited[i] = false;
		}
	}

	public static int calTeam(int[] members) {

		int sum = 0;
		for (int i = 0; i < members.length; ++i) {
			for (int j = 0; j < members.length; ++j) {
				if (i != j) {
					sum += team[members[i]][members[j]];
				}
			}
		}
		return sum;
	}
}
