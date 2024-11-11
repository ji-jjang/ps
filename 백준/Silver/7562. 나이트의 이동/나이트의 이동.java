import java.io.*;
import java.util.*;

// BFS, O(n^2)
public class Main {
	
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static Queue<int[]> q; // y, x , moveCount
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			q = new LinkedList<>();
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			board[sy][sx] = 1;
			q.offer(new int[]{sy, sx, 0});
			st = new StringTokenizer(br.readLine());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());

			while (!q.isEmpty()) {
				var cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				int moveCount = cur[2];
				if (y == ey && x == ex) {
					sb.append(moveCount + "\n");
					break;
				}
				for (int dir = 0; dir < 8; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
					if (board[ny][nx] != 0) continue;
					board[ny][nx] = 1;
					q.offer(new int[]{ny, nx, moveCount + 1});
				}
			}
		}
		System.out.println(sb);
	}
}
