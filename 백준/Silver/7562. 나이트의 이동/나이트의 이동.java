import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int l = Integer.parseInt(br.readLine());
			int[][] board = new int[l][l];
			boolean[][] isVisited = new boolean[l][l];
			Queue<int[]> q = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			isVisited[sy][sx] = true;
			q.offer(new int[]{sy, sx, 0});

			st = new StringTokenizer(br.readLine());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());

			while (!q.isEmpty()) {
				var cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				int move = cur[2];
				if (y == ey && x == ex) {
					sb.append(move + "\n");
					break;
				}
				for (int dir = 0; dir < 8; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= l || nx < 0 || nx >= l) continue;
					if (isVisited[ny][nx]) continue;
					isVisited[ny][nx] = true;
					q.offer(new int[]{ny, nx, move + 1});
				}
			}
		}
		System.out.println(sb);
	}
}
