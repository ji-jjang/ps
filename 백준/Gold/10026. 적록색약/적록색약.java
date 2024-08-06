import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][n];
		char[][] board2 = new char[n][n];

		for (int i = 0; i < n; ++i) {
			String line = br.readLine();
			for (int j = 0; j < n; ++j) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'R') {
					board2[i][j] = 'G';
				} else {
					board2[i][j] = board[i][j];
				}
			}
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[n][n];
		int area1 = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!isVisited[i][j]) {	
					++area1;
					q.offer(new int[]{i, j});
					isVisited[i][j] = true;
				}
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					char color = board[y][x];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (board[ny][nx] != color || isVisited[ny][nx]) continue;
						isVisited[ny][nx] = true;
						q.offer(new int[]{ny, nx});
					}
				}
			}
		}
		q.clear();
		for (int i = 0; i < n; ++i) {
			Arrays.fill(isVisited[i], false);
		}

		int area2 = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!isVisited[i][j]) {	
					++area2;
					q.offer(new int[]{i, j});
					isVisited[i][j] = true;
				}
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					char color = board2[y][x];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (board2[ny][nx] != color || isVisited[ny][nx]) continue;
						isVisited[ny][nx] = true;
						q.offer(new int[]{ny, nx});
					}
				}
			}
		}
		System.out.println(area1 + " " + area2);
	}
}
