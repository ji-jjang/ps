import java.io.*;
import java.util.*;

// BFS, O(h * r * c)
public class Main {
	
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static Queue<int[]> q = new LinkedList<>();
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] board = new int[h][r][c];
		int[][][] dist = new int[h][r][c];
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < r; ++j) {
				Arrays.fill(dist[i][j], -1);
			}
		}

		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < r; ++j) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; ++k) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if (board[i][j][k] == 1) {
						dist[i][j][k] = 0;
						q.offer(new int[]{i, j, k});
					}
				}
			}
		}
		while (!q.isEmpty()) {
			var cur = q.poll();
			int z = cur[0];
			int y = cur[1];
			int x = cur[2];
			for (int dir = 0; dir < 6; ++dir) {
				int nz = z + dz[dir];
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (nz < 0 || nz >= h || ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[nz][ny][nx] != 0 || dist[nz][ny][nx] != -1) continue;
				dist[nz][ny][nx] = dist[z][y][x] + 1;
				q.offer(new int[]{nz, ny, nx});
			}
		}
		int ans = 0;
		for (int i = 0; i < h; ++i) {
			for (int j = 0; j < r; ++j) {
				for (int k = 0; k < c; ++k) {
					if (board[i][j][k] == 0 && dist[i][j][k] == -1) {
						System.out.println(-1);
						return;
					}
					ans = Math.max(ans, dist[i][j][k]);
				}
			}
		}
		System.out.println(ans);
	}
}
