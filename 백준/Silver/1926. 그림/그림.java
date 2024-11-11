import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] board = new int[r][c];

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		int picCount = 0;
		int maxPicSize = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (board[i][j] == 1) {
					++picCount;
					board[i][j] = 2;
					q.offer(new int[]{i, j});
				}
				int cnt = 0;
				while (!q.isEmpty()) {
					++cnt;
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
						if (board[ny][nx] != 1) continue;
						board[ny][nx] = 2;
						q.offer(new int[]{ny, nx});
					}
				}
				maxPicSize = Math.max(maxPicSize, cnt);
			}
		}
		System.out.println(picCount + "\n" + maxPicSize);
	}
}
