import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		int[][] board = new int[r][c];

		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j] - '0';
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{0, 0});
		board[0][0] = -1;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] != 1) continue;
				board[ny][nx] = board[y][x] - 1;
				q.offer(new int[]{ny, nx});
			}
		}
		System.out.println(board[r - 1][c - 1] * -1);
	}
}
