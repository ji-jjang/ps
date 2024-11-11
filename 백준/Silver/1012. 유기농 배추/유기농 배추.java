import java.io.*;
import java.util.*;

// BFS, O(n)
public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] board = new int[r][c];
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			Queue<int[]> q = new LinkedList<>();
			
			int cnt = 0;
			int[] dy = {-1, 0, 1, 0};
			int[] dx = {0, 1, 0, -1};
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (board[i][j] == 1) {
						board[i][j] = 2;
						q.offer(new int[]{i, j});
						++cnt;
					}
					while (!q.isEmpty()) {
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
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
