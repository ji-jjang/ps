import java.util.*;
import java.io.*;

public class Main {

	static int[][] p;
	static int n, m;
	static boolean[][] isVisited;
	static int ans = 0;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n][m];
		isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				p[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				isVisited[i][j] = true;
				dfs(0, i, j, p[i][j]);
				isVisited[i][j] = false;
			}
		}
		System.out.println(ans);
	}

	static void dfs(int depth, int y, int x, int sum) {
		
		if (depth == 3) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int dir = 0; dir < 4; ++dir) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if (isVisited[ny][nx]) continue;
			isVisited[ny][nx] = true;
			dfs(depth + 1, ny, nx, sum + p[ny][nx]);
			if (depth == 1) {
				dfs(depth + 1, y, x, sum + p[ny][nx]);
			}
			isVisited[ny][nx] = false;
		}
	}
}
