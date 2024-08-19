import java.io.*; import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[r][c];
		int[][][][] dist = new int[r][c][k + 1][2];

		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j) - '0';
				for (int l = 0; l <= k; ++l) {
					for (int m = 0; m < 2; ++m) {
						dist[i][j][l][m] = -1;
					}
				}
			}
		}
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		Queue<int[]> q = new ArrayDeque<>(); // y, x, breakCnt, day - 0(낮), 1(밤)
		dist[0][0][0][0] = 0;
		q.offer(new int[]{0, 0, 0, 0});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			int day = cur[3];
			if (y == r - 1 && x == c - 1) {
				System.out.println(dist[y][x][cnt][day] + 1);
				return;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				int nxtDay = (day == 0) ? 1 : 0;
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] == 1) {
					if (cnt >= k)
						continue;
					if (day == 1) {
						if (dist[y][x][cnt][nxtDay] != -1) continue;
						dist[y][x][cnt][nxtDay] = dist[y][x][cnt][day] + 1;
						q.offer(new int[]{y, x, cnt, nxtDay});
						continue;
					}
					if (dist[ny][nx][cnt + 1][nxtDay] != -1) continue;
					dist[ny][nx][cnt + 1][nxtDay] = dist[y][x][cnt][day] + 1;
					q.offer(new int[]{ny, nx, cnt + 1, nxtDay});
				} 
				else {
					if (dist[ny][nx][cnt][nxtDay] != -1)
						continue;
					dist[ny][nx][cnt][nxtDay] = dist[y][x][cnt][day] + 1;
					q.offer(new int[]{ny, nx, cnt, nxtDay});
				}
			}
		}
		System.out.println(-1);
	}
}
