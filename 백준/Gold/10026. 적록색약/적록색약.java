import java.io.*;
import java.util.*;

// BFS, O(n * n)
public class Main {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static Queue<int[]> q = new LinkedList<>();
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		char[][] board = new char[n][n];
		char[][] blBoard = new char[n][n];
		for (int i = 0; i < n; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < n; ++j) {
				board[i][j] = line[j];
				blBoard[i][j] = line[j];
				if (blBoard[i][j] == 'G') {
					blBoard[i][j] = 'R';
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		bfs(sb, board, new boolean[n][n]);
		bfs(sb, blBoard, new boolean[n][n]);
		System.out.println(sb);
	}

	static void bfs(StringBuilder sb, char[][] board, boolean[][] isVisited) {

		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!isVisited[i][j]) {
					++cnt;
					q.offer(new int[]{i, j});
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
		sb.append(cnt + " ");
	}
}
