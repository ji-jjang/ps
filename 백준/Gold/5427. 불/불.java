import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			char[][] board = new char[r][c];
			int[][] sDist = new int[r][c];
			int[][] fDist = new int[r][c];
			for (int i = 0; i < r; ++i) {
				Arrays.fill(sDist[i], -1);
				Arrays.fill(fDist[i], -1);
			}
			Queue<int[]> sq = new LinkedList<>();
			Queue<int[]> fq = new LinkedList<>();
			int[] dy = {-1, 0, 1, 0};
			int[] dx = {0, 1, 0, -1};

			for (int i = 0; i < r; ++i) {
				String line = br.readLine();
				for (int j = 0; j < c; ++j) {
					board[i][j] = line.charAt(j);
					if (board[i][j] == '*') {
						fDist[i][j] = 0;
						fq.offer(new int[]{i, j});
						board[i][j] = '.';
					} else if (board[i][j] == '@') {
						sDist[i][j] = 0;
						sq.offer(new int[]{i, j});
						board[i][j] = '.';
					}
				}
			}

			while (!fq.isEmpty()) {
				var cur = fq.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] != '.' || fDist[ny][nx] != -1) continue;
					fDist[ny][nx] = fDist[y][x] + 1;
					fq.offer(new int[]{ny, nx});
				}
			}

			boolean isPossible = false;
			while (!sq.isEmpty()) {
				var cur = sq.poll();
				int y = cur[0];
				int x = cur[1];
				if (y == 0 || y == r - 1 || x == 0 || x == c - 1) {
					sb.append(sDist[y][x] + 1);
					sb.append("\n");
					isPossible = true;
					break;
				}
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] != '.' || sDist[ny][nx] != -1) continue;
					if (fDist[ny][nx] != -1 && sDist[y][x] + 1 >= fDist[ny][nx]) continue;
					sDist[ny][nx] = sDist[y][x] + 1;
					sq.offer(new int[]{ny, nx});
				}
			}
			if (!isPossible)
				sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
	}
}
