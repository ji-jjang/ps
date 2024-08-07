import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] board = new int[r][c];
		boolean[][] isVisited = new boolean[r][c];

		while (t-- > 0) {
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
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();
		List<Integer> emptyAreas = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				int cnt = 0;
				if (!isVisited[i][j] && board[i][j] == 0) {
					isVisited[i][j] = true;
					q.offer(new int[]{i, j});
					++ans;
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
						if (board[ny][nx] == 1 || isVisited[ny][nx]) continue;
						++cnt;
						isVisited[ny][nx] = true;
						q.offer(new int[]{ny, nx});
					}
				}
				if (cnt != 0) 
					emptyAreas.add(cnt);
			}
		}
		emptyAreas.sort((a, b) -> Integer.compare(a, b));
		sb.append(ans + "\n");
		for (var e : emptyAreas) {
			sb.append(e + " ");
		}
		System.out.println(sb);
	}
}
