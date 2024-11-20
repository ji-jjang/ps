import java.io.*;
import java.util.*;

// BFS, O(r * c)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int r = Integer.parseInt(tokens[0]);
		int c = Integer.parseInt(tokens[1]);
		char[][] board = new char[r][c];
		int[][] isVisited = new int[r][c];

		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> tmp1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		Queue<int[]> tmp2 = new LinkedList<>();
		Queue<int[]> wq = new LinkedList<>();

		boolean isFirst = true;
		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j];
				if (board[i][j] == 'L' && isFirst) {
					isVisited[i][j] = 1;
					q1.offer(new int[]{i, j});
					wq.offer(new int[]{i, j});
					isFirst = false;
				} else if (board[i][j] == 'L') {
					isVisited[i][j] = 2;
					q2.offer(new int[]{i, j});
					wq.offer(new int[]{i, j});
				} else if (board[i][j] == '.') {
					wq.offer(new int[]{i, j});
				}
			}
		}
		boolean isMet = false;
		int day = 0;
		while (true) {


			while (!tmp1.isEmpty()) {
				var cur = tmp1.poll();
				int y = cur[0];
				int x = cur[1];
				if (isVisited[y][x] == 0) {
					isVisited[y][x] = 1;
					q1.offer(new int[]{y, x});
				}
			}

			while (!q1.isEmpty()) {
				var cur = q1.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (isVisited[ny][nx] == 1) continue;
					if (isVisited[ny][nx] == 2) {
						isMet = true;
						break;
					}
					if (board[ny][nx] == 'X') {
						tmp1.offer(new int[]{ny, nx});
						continue; 
					}
					isVisited[ny][nx] = 1;
					q1.offer(new int[]{ny, nx});
				}
				if (isMet) break;
			}

			if (isMet) break;

			while (!tmp2.isEmpty()) {
				var cur = tmp2.poll();
				int y = cur[0];
				int x = cur[1];
				if (isVisited[y][x] == 0) {
					isVisited[y][x] = 2;
					q2.offer(new int[]{y, x});
				}
			}
			while (!q2.isEmpty()) {
				var cur = q2.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (isVisited[ny][nx] == 2) continue;
					if (isVisited[ny][nx] == 1) {
						isMet = true;
						break;
					}
					if (board[ny][nx] == 'X') {
						tmp2.offer(new int[]{ny, nx});
						continue; 
					}
					isVisited[ny][nx] = 2;
					q2.offer(new int[]{ny, nx});
				}
				if (isMet) break;
			}
			if (isMet) break;
			int size = wq.size();
			for (int i = 0; i < size; ++i) {
				var cur = wq.poll();
				int y = cur[0];
				int x = cur[1];

				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
					if (board[ny][nx] == 'X') {
						board[ny][nx] = '.';
						wq.offer(new int[]{ny, nx});
					}
				}
			}
			++day;
		}
		System.out.println(day);
	}
}


