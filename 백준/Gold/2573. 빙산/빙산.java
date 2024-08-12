import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] board = new int[r][c];
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		int ans = 0;
		while (true) {
			boolean isAllMelted = true;
			int[][] tmp = new int[r][c];
			boolean[][] isVisited = new boolean[r][c];
			Queue<int[]> q = new LinkedList<>();

			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (board[i][j] != 0) {
						isAllMelted = false;
						int zeroCnt = 0;
						for (int dir = 0; dir < 4; ++dir) {
							int ni = i + dy[dir];
							int nj = j + dx[dir];
							if (ni < 0 || ni >= r || nj < 0 || nj >= c) continue;
							if (board[ni][nj] != 0) continue;
							++zeroCnt;
						}
						tmp[i][j] = zeroCnt;
					}
				}
			}

			++ans;
			if (isAllMelted) {
				ans = 0;
				break;
			}

			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					board[i][j] = Math.max(0, board[i][j] - tmp[i][j]);
				}
			}

			int splitedCnt = 0;
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					if (board[i][j] != 0 && !isVisited[i][j]) {
						splitedCnt++;
						if (splitedCnt > 1) {
							break;
						}
						isVisited[i][j] = true;
						q.offer(new int[]{i, j});
						while (!q.isEmpty()) {
							var cur = q.poll();
							int y = cur[0];
							int x = cur[1];
							for (int dir = 0; dir < 4; ++dir) {
								int ny = y + dy[dir];
								int nx = x + dx[dir];
								if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
								if (board[ny][nx] == 0 || isVisited[ny][nx]) continue;
								isVisited[ny][nx] = true;
								q.offer(new int[]{ny, nx});
							}
						}
					}
				}
				if (splitedCnt > 1) break;
			}

			if (splitedCnt > 1) break;
		}
		System.out.println(ans);
	}
}
