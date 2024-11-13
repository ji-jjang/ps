import java.io.*;
import java.util.*;

// BFS, O(r * c * k)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int r = Integer.parseInt(tokens[0]);
		int c = Integer.parseInt(tokens[1]);
		int k = Integer.parseInt(tokens[2]);

		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][k + 1];
		
		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j] - '0';
				Arrays.fill(dist[i][j], -1);
			}
		}

		Queue<int[]> q = new LinkedList<>(); // y, x, remainBreakCnt
		dist[0][0][k] = 1;
		q.offer(new int[]{0, 0, k});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			if (y == r - 1 && x == c - 1) {
				System.out.println(dist[y][x][cnt]);
				return;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] == 1 && cnt > 0) {
					if (dist[ny][nx][cnt - 1] != -1) continue;
					dist[ny][nx][cnt - 1] = dist[y][x][cnt] + 1;
					q.offer(new int[]{ny, nx, cnt - 1});
				}
				if (board[ny][nx] == 1 || dist[ny][nx][cnt] != -1) continue;
				dist[ny][nx][cnt] = dist[y][x][cnt] + 1;
				q.offer(new int[]{ny, nx, cnt});
			}
		}
		System.out.println(-1);
	}
}
