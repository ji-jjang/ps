import java.io.*;
import java.util.*;

// BFS, O(r * c * k)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][k + 1];

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dist[i][j], -1);
			}
		}

		Queue<int[]> q = new LinkedList<>(); // y, x, horseMoveCnt
		dist[0][0][k] = 0;
		q.offer(new int[]{0, 0, k});
		boolean isArrive = false;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int horse = cur[2];
			if (y == r - 1 && x == c - 1) {
				isArrive = true;
				System.out.println(dist[y][x][horse]);
				break;
			}
			if (horse > 0) {
				for (int dir = 0; dir < 8; ++dir) {
					int ny = y + hy[dir];
					int nx = x + hx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] == 1 || dist[ny][nx][horse - 1] != -1) continue;
					dist[ny][nx][horse - 1] = dist[y][x][horse] + 1;
					q.offer(new int[]{ny, nx, horse - 1});
				}
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] == 1 || dist[ny][nx][horse] != -1) continue;
				dist[ny][nx][horse] = dist[y][x][horse] + 1;
				q.offer(new int[]{ny, nx, horse});
			}
		}
		if (!isArrive)
			System.out.println(-1);
	}
}
