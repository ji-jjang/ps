import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

	static int n;
	static int[][] table;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		table = new int[n][n];

		for (int i = 0; i < n; ++i) {
			String[] tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				table[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		dfs(0, 0, new ArrayList<>());

		System.out.println(ans);
	}

	static void dfs(int depth, int st, List<Integer> selected) {
		
		if (depth == n / 2) {

		 List<Integer> notSelected = IntStream.range(0, n)
						.boxed()
						.filter(num -> !selected.contains(num))
						.collect(Collectors.toList());

			ans = Math.min(ans, Math.abs(calc(selected) - calc(notSelected)));

			return;
		}
		for (int i = st; i < n; ++i) {
			selected.add(i);
			dfs(depth + 1, i + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}

	static int calc(List<Integer> team) {

		int score = 0;
		for (int i = 0; i < team.size(); ++i) {
			for (int j = 0; j < team.size(); ++j) {
				if (i != j) {
					score += table[team.get(i)][team.get(j)];
				}
			}
		}
		return score;
	}
}
