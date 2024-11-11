import java.io.*;
import java.util.*;

// BFS, O(n * h * r * c)
public class Main {

	static int[] dz = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 0, -1, 1};
	static Queue<int[]> q; // h, r, c, move
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (h == 0 && r == 0 && c == 0) break;

			q = new LinkedList<>();
			int[] arriveCoord = new int[3];

			char[][][] board = new char[h][r][c];
			for (int i = 0; i < h; ++i) {
				for (int j = 0; j < r; ++j) {
					char[] line = br.readLine().toCharArray();
					for (int k = 0; k < c; ++k) {
						board[i][j][k] = line[k];
						if (board[i][j][k] == 'S') {
							board[i][j][k] = 'a';
							q.offer(new int[]{i, j, k, 0});
						}
						else if (board[i][j][k] == 'E') {
							arriveCoord[0] = i; arriveCoord[1] = j; arriveCoord[2] = k;
							board[i][j][k] = '.';
						}
					}
				}
				br.readLine();
			}

			int ans = 0;
			boolean isArrived = false;
			while (!q.isEmpty()) {
				var cur = q.poll();
				int z = cur[0];
				int y = cur[1];
				int x = cur[2];
				int move = cur[3];
				if (z == arriveCoord[0] && y == arriveCoord[1] && x == arriveCoord[2]) {
					isArrived = true;
					ans = move;
					break;
				}
				for (int dir = 0; dir < 6; ++dir) {
					int nz = z + dz[dir];
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (nz < 0 || nz >= h || ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[nz][ny][nx] != '.') continue;
					board[nz][ny][nx] = 'a';
					q.offer(new int[]{nz, ny, nx, move + 1});
				}
			}
			if (!isArrived) {
				sb.append("Trapped!\n");
				continue;
			}
			sb.append("Escaped in " + ans + " minute(s).\n");
		}
		System.out.println(sb);
	}
}
