import java.util.*;
import java.io.*;

public class Main {

	static int n, m;
	static int[][] city;
	static List<int[]> chickens = new ArrayList<>();
	static List<int[]> houses = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		n = Integer.parseInt(tokens[0]);
		m = Integer.parseInt(tokens[1]);

		city = new int[n][n];
		for (int i = 0; i < n; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < n; ++j) {
				city[i][j] = Integer.parseInt(tokens[j]);
				if (city[i][j] == 1) {
					houses.add(new int[]{i, j});
				}
				else if (city[i][j] == 2) {
					chickens.add(new int[]{i, j});
				}
			}
		}
		dfs(0, 0, new ArrayList<>(), new boolean[chickens.size()]);
		System.out.println(ans);
	}

	static void dfs(int depth, int st, List<Integer> selected, boolean[] isVisited) {

		if (depth == m) {

			int totalDist = 0;
			for (var h : houses) {

				int chickenDist = Integer.MAX_VALUE;
				for (int i = 0; i < m; ++i) {
					int idx = selected.get(i);
					chickenDist = Math.min(chickenDist, Math.abs(h[0] - chickens.get(idx)[0]) + Math.abs(h[1] - chickens.get(idx)[1]));
				}
				totalDist += chickenDist;
			}
			ans = Math.min(ans, totalDist);
			return; 
		}

		for (int i = st; i < chickens.size(); ++i) {

			if (isVisited[i]) continue;
			isVisited[i] = true;
			selected.add(i);
			dfs(depth + 1, i, selected, isVisited);
			selected.remove(selected.size() - 1);
			isVisited[i] = false;
		}
	}
}
