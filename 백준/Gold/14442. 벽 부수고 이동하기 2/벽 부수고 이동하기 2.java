import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][k + 1];
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				for (int l = 0; l <= k; ++l) {
					dist[i][j][l] = -1;
				}
			}
		}

		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j) - '0';
			}
		}
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		Queue<int[]> q = new LinkedList<>(); // y, x, breakCnt;
		dist[0][0][0] = 0;
		q.offer(new int[]{0, 0, 0});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			if (y == r - 1 && x == c - 1) {
				System.out.println(dist[y][x][cnt] + 1);
				return;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] == 1) {
					if (cnt >= k)
						continue;
					if (dist[ny][nx][cnt + 1] != -1) continue;
					dist[ny][nx][cnt + 1] = dist[y][x][cnt] + 1;
					q.offer(new int[]{ny, nx, cnt + 1});
				} 
				else {
					if (dist[ny][nx][cnt] != -1)
						continue;
					dist[ny][nx][cnt] = dist[y][x][cnt] + 1;
					q.offer(new int[]{ny, nx, cnt});
				}
			}
		}
		System.out.println(-1);
	}
}
