import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] board = new int[h][r][c];
		int[][][] dist = new int[h][r][c];
		for (int k = 0; k < h; ++k) {
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					dist[k][i][j] = -1;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>();

		for (int k = 0; k < h; ++k) {
			for (int i = 0; i < r; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; ++j) {
					board[k][i][j] = Integer.parseInt(st.nextToken());
					if (board[k][i][j] == 1) {
						dist[k][i][j] = 0;
						q.offer(new int[]{k, i, j});
					}
				}
			}
		}
		int[] dz = {-1, 1, 0, 0, 0, 0};
		int[] dy = {0, 0, -1, 1, 0, 0}; 
		int[] dx = {0, 0, 0, 0, -1, 1}; 
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

		boolean isImpossible = false;
		int ans = 0;
		for (int k = 0; k < h; ++k) {
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (board[k][i][j] == 0 && dist[k][i][j] == -1) {
						System.out.println(-1);
						return;
					}
					ans = Math.max(ans, dist[k][i][j]);
				}
			}
		}
		System.out.println(ans);
	}
}
