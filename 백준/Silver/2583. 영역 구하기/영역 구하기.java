import java.io.*;
import java.util.*;

// BFS, O(t * r * c)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for (int i = sy; i < ey; ++i) {
				for (int j = sx; j < ex; ++j) {
					board[i][j] = 1;
				}
			}
		}
		int areaCount = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (board[i][j] == 0) {
					++areaCount;
					board[i][j] = 1;
					q.offer(new int[]{i, j});
				}
				int cnt = 0;
				while (!q.isEmpty()) {
					var cur = q.poll();
					++cnt;
					int y = cur[0];
					int x = cur[1];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
						if (board[ny][nx] != 0) continue;
						board[ny][nx] = 1;
						q.offer(new int[]{ny, nx});
					}
				}
				if (cnt > 0) pq.offer(cnt);
			}
		}
		sb.append(areaCount + "\n");
		while (!pq.isEmpty()) {
			var cur = pq.poll();
			sb.append(cur + " ");
		}
		System.out.println(sb);
	}
}
