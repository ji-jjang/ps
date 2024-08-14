import java.util.*;
import java.io.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][k + 1];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				for (int s = 0; s <= k; ++s) {
					dist[i][j][s] = -1;
				}
			}
		}
		Queue<int[]> q = new LinkedList<>(); // y, x, horseMoveCnt
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dist[0][0][0] = 0;
		q.offer(new int[]{0, 0, 0});

		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int hCnt = cur[2];
			if (y == r - 1 && x == c - 1) {
				System.out.println(dist[y][x][hCnt]);
				return;
			}
			
			if (hCnt < k) {
				for (int hDir = 0; hDir < 8; ++hDir) {
					int ny = y + hy[hDir];
					int nx = x + hx[hDir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] != 0 || dist[ny][nx][hCnt + 1] != -1) continue;
					dist[ny][nx][hCnt + 1] = dist[y][x][hCnt] + 1;
					q.offer(new int[]{ny, nx, hCnt + 1});
				}
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] != 0 || dist[ny][nx][hCnt] != -1) continue;
				dist[ny][nx][hCnt] = dist[y][x][hCnt] + 1;
				q.offer(new int[]{ny, nx, hCnt});
			}
		}
		System.out.println(-1);
	}
}

