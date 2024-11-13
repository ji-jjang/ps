import java.io.*;
import java.util.*;

// BFS, O(r * c * k)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int DAY = 0;
	static int NIGHT = 1;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int r = Integer.parseInt(tokens[0]);
		int c = Integer.parseInt(tokens[1]);
		int k = Integer.parseInt(tokens[2]);

		int[][] board = new int[r][c];
		int[][][][] dist = new int[r][c][k + 1][2]; 
		Queue<int[]> q = new ArrayDeque<>(); // y, x, break, day

		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j] - '0';
				for (int m = 0; m < k + 1; ++m) {
					Arrays.fill(dist[i][j][m], -1);
				}
			}
		}

		dist[0][0][k][DAY] = 1;
		q.offer(new int[]{0, 0, k, DAY});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			int dayTime = cur[3];
			int nxtDay = (dayTime == DAY) ? NIGHT : DAY;
			if (y == r - 1 && x == c - 1) {
				System.out.println(dist[y][x][cnt][dayTime]);
				return;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (cnt > 0 && board[ny][nx] == 1) {
					if (dayTime == DAY && dist[ny][nx][cnt - 1][nxtDay] == -1) {
						dist[ny][nx][cnt - 1][nxtDay] = dist[y][x][cnt][dayTime] + 1;
						q.offer(new int[]{ny, nx, cnt - 1, nxtDay});
					}
					if (dayTime == NIGHT && dist[ny][nx][cnt - 1][nxtDay] == -1) {
						dist[y][x][cnt][nxtDay] = dist[y][x][cnt][dayTime] + 1;
						q.offer(new int[]{y, x, cnt, nxtDay});
					}
				}
				if (board[ny][nx] == 0 && dist[ny][nx][cnt][nxtDay] == -1) {
					dist[ny][nx][cnt][nxtDay] = dist[y][x][cnt][dayTime] + 1;
					q.offer(new int[]{ny, nx, cnt, nxtDay});
				}
			}
		}
		System.out.println(-1);
	}
}
