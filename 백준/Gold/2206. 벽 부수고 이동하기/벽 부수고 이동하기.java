import java.io.*;
import java.util.*;

// BFS, O(r * c)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][2];

		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j] - '0';
			}
		}
		dist[0][0][0] = 1;
		q.offer(new int[]{0, 0, 0});
		boolean isArrive = false;
		int ans = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int breakCnt = cur[2];
			if (y == r - 1 && x == c - 1) {
				isArrive = true;
				ans = dist[y][x][breakCnt];
				break;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (dist[ny][nx][breakCnt] != 0) continue;
				if (board[ny][nx] == 1) {
					if (breakCnt < 1 && dist[ny][nx][breakCnt + 1] == 0) {
						dist[ny][nx][breakCnt + 1] = dist[y][x][breakCnt] + 1;
						q.offer(new int[]{ny, nx, breakCnt + 1});
					} 
				}
				else {
					dist[ny][nx][breakCnt] = dist[y][x][breakCnt] + 1;
					q.offer(new int[]{ny, nx, breakCnt});
				}
			}
		}
		if (isArrive) {
			System.out.println(ans);
			return;
		}
		System.out.println(-1);
	}
}
