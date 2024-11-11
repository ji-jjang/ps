import java.io.*;
import java.util.*;

// BFS, O()
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < n; ++j) {
				board[i][j] = line[j] - '0';
			}
		}

		int areaCount = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == 1) {
					++areaCount;
					board[i][j] = 2;
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
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (board[ny][nx] != 1) continue;
						board[ny][nx] = 2;
						q.offer(new int[]{ny, nx});
					}
				}
				if (cnt > 0) pq.offer(cnt);
			}
		}
		sb.append(areaCount + "\n");
		while (!pq.isEmpty()) {
			var cur = pq.poll();
			sb.append(cur + "\n");
		}
		System.out.println(sb);
	}
}
