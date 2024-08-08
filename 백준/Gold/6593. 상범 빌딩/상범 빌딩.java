import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int dz[] = {-1, 1, 0, 0, 0, 0};
		int dy[] = {0, 0, -1, 1, 0, 0};
		int dx[] = {0, 0, 0, 0, -1, 1};

		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (h == 0 && r == 0 && c == 0) break;

			int[][][] dist = new int[h][r][c];
			Queue<int[]> q = new LinkedList<>();

			for (int k = 0; k < h; ++k) {
				for (int i = 0; i < r; ++i) {
					for (int j = 0; j < c; ++j)
						dist[k][i][j] = -1;
				}
			}
			char[][][] board = new char[h][r][c];
			int ez = 0, ey = 0, ex = 0;
			for (int k = 0; k < h; ++k) {
				for (int i = 0; i < r; ++i) {
					String line = br.readLine();
					for (int j = 0; j < c; ++j) {
						board[k][i][j] = line.charAt(j);
						if (board[k][i][j] == 'S') {
							dist[k][i][j] = 0;
							q.offer(new int[]{k, i, j});
							board[k][i][j] = '.';
						}
						if (board[k][i][j] == 'E') {
							board[k][i][j] = '.';
							ez = k;
							ey = i;
							ex = j;
						}
					}
				}
				br.readLine();
			}
			int ans = -1;
			while (!q.isEmpty()) {
				var cur = q.poll();
				int z = cur[0];
				int y = cur[1];
				int x = cur[2];
				if (z == ez && y == ey && x == ex) {
					ans = dist[z][y][x];
					break;
				}
				for (int dir = 0; dir < 6; ++dir) {
					int nz = z + dz[dir];
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (nz < 0 || nz >= h || ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[nz][ny][nx] != '.' || dist[nz][ny][nx] != -1) continue;
					dist[nz][ny][nx] = dist[z][y][x] + 1;
					q.offer(new int[]{nz, ny, nx});
				}
			}
			if (ans == -1) sb.append("Trapped!\n");
			else sb.append("Escaped in " + ans + " minute(s).\n");
		}
		System.out.println(sb);
	}
}
