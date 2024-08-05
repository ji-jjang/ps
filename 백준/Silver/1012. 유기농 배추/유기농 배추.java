import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][]board = new int[r][c];
			boolean[][] isVisited = new boolean[r][c];

			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			Queue<int[]> q = new LinkedList<>();
			int ans = 0;
			int[] dy = {1, 0, -1, 0};
			int[] dx = {0, 1, 0, -1};

			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (board[i][j] == 1 && !isVisited[i][j]) {
						++ans;
						isVisited[i][j] = true;
						q.offer(new int[]{i, j});
					}
					while (!q.isEmpty()) {
						var cur = q.poll();

						for (int dir = 0; dir < 4; ++dir) {
							int ny = cur[0] + dy[dir];
							int nx = cur[1] + dx[dir];
							if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
							if (board[ny][nx] == 0 || isVisited[ny][nx]) continue;
							isVisited[ny][nx] = true;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
