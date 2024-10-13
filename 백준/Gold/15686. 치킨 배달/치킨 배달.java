import java.io.*;
import java.util.*;


public class Main {

	static int[][] map;
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> chickens = new ArrayList<>();
	static int[] isSelected;
	static int n, m;
	static int ans = 0x7fffffff;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		isSelected = new int[m];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) houses.add(new int[]{i, j});
				else if (map[i][j] == 2) chickens.add(new int[]{i, j});
			}
		}
		dfs(0, 0);
		System.out.println(ans);
	}

	public static void dfs(int depth, int st) {

		if (depth == m) {
			int perChickDist = 0;
			for (var h : houses) {
				int hy = h[0];
				int hx = h[1];
				int minChickDist = 0x7fffffff;
				for (int i = 0; i < m; ++i) {
					int cy = chickens.get(isSelected[i])[0];
					int cx = chickens.get(isSelected[i])[1];
					minChickDist = Math.min(minChickDist, Math.abs(hy - cy) + Math.abs(hx - cx));
				}
				perChickDist += minChickDist;
			}
			ans = Math.min(ans, perChickDist);
			return;
		}
		for (int i = st; i < chickens.size(); ++i) {
			isSelected[depth] = i;
			dfs(depth + 1, i + 1);
		}
	}
}
