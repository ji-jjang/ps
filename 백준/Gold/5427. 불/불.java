import java.io.*;
import java.util.*;

// BFS, O(t * r * c)
public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> jq, fq;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			jq = new LinkedList<>();
			fq = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			char[][] board = new char[r][c];
			int[][] jdist = new int[r][c];
			int[][] fdist = new int[r][c];
			for (int i = 0; i < r; ++i) {
				Arrays.fill(jdist[i], -1);
				Arrays.fill(fdist[i], -1);
			}
			for (int i = 0; i < r; ++i) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < c; ++j) {
					board[i][j] = line[j];
					if (board[i][j] == '@') {
						board[i][j] = '.';
						jdist[i][j] = 1;
						jq.offer(new int[]{i, j});
					}
					else if (board[i][j] == '*') {
						board[i][j] = '.';
						fdist[i][j] = 1;
						fq.offer(new int[]{i, j});
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
					if (board[ny][nx] != '.' || fdist[ny][nx] != -1) continue;
					fdist[ny][nx] = fdist[y][x] + 1;
					fq.offer(new int[]{ny, nx});
				}
			}
			boolean isEscape = false;
			int moveCount = 0;
			while (!jq.isEmpty()) {
				var cur = jq.poll();
				int y = cur[0];
				int x = cur[1];
				if (y == 0 || y == r - 1 || x == 0 || x == c -1) {
					isEscape = true;
					moveCount = jdist[y][x];
					break;
				}
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] != '.' || jdist[ny][nx] != -1) continue;
					if (fdist[ny][nx] != -1 && fdist[ny][nx] <= jdist[y][x] + 1) continue;
					jdist[ny][nx] = jdist[y][x] + 1;
					jq.offer(new int[]{ny, nx});
				}
			}
			if (isEscape) {
				sb.append(moveCount + "\n");
				continue;
			}
			sb.append("IMPOSSIBLE\n");
		}
		System.out.println(sb);
	}
}
