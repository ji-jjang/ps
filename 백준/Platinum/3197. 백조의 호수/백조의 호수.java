import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] board = new char[r][c];
		boolean[][] isVisited = new boolean[r][c];
		boolean[][] isVisited2 = new boolean[r][c];

		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		Queue<int[]> l = new LinkedList<>();
		Queue<int[]> l2 = new LinkedList<>();
		
		int[] pos = {0, 0};
		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j);
				if (board[i][j] != 'X') {
					q.offer(new int[]{i, j});
				}
			  if (board[i][j] == 'L') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};

		board[pos[0]][pos[1]] = '.';
		isVisited2[pos[0]][pos[1]] = true;
		l.offer(new int[]{pos[0], pos[1]});
		boolean isMet = false;
		int ans = 0;
		while (!isMet) {

			while (!q.isEmpty()) {
				var cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				isVisited[y][x] = true;
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (isOOB(ny, nx, r, c) || isVisited[ny][nx]) continue;
					isVisited[ny][nx] = true;
					if (board[ny][nx] == 'X') {
						q2.offer(new int[]{ny, nx});
					}
				}
			}
			while (!q2.isEmpty()) {
				var cur = q2.poll();
				int y = cur[0];
				int x = cur[1];
				board[y][x] = '.';
				q.offer(new int[]{y, x});
			}
			++ans;

			while (!l.isEmpty()) {
				var cur = l.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (isOOB(ny, nx, r, c) || isVisited2[ny][nx]) continue;
					if (board[ny][nx] == 'X') {
						isVisited2[ny][nx] = true;
						l2.offer(new int[]{ny, nx});
						continue;
					}
					if (board[ny][nx] == 'L') {
						isMet = true;
						break;
					}
					isVisited2[ny][nx] = true;
					l.offer(new int[]{ny, nx});
				}
			}
			while (!l2.isEmpty()) {
				var cur = l2.poll();
				int y = cur[0];
				int x = cur[1];
				l.offer(new int[]{y, x});
			}
		}
		System.out.println(ans);
	}

	static boolean isOOB(int y, int x, int r, int c) {
		return y < 0 || y >= r || x < 0 || x >= c;
	}
}

