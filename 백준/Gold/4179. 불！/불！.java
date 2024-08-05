import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char[][] board = new char[r][c];
		int[][] jDist = new int[r][c];
		int[][] fDist = new int[r][c];

		for (int i = 0; i < r; ++i) {
			Arrays.fill(jDist[i], -1);
			Arrays.fill(fDist[i], -1);
		}

		Queue<int[]> jq = new LinkedList<>();
		Queue<int[]> fq = new LinkedList<>();
		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'J') {
					jq.offer(new int[]{i, j});
					jDist[i][j] = 0;
					board[i][j] = '.';
				} else if (board[i][j] == 'F') {
					fq.offer(new int[]{i, j});
					fDist[i][j] = 0;
					board[i][j] = '.';
				}
			}
		}

		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};

		while (!fq.isEmpty()) {
			var cur = fq.poll();
			int y = cur[0];
			int x = cur[1];
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (fDist[ny][nx] != -1 || board[ny][nx] != '.') continue;
				fDist[ny][nx] = fDist[y][x] + 1;
				fq.offer(new int[]{ny, nx});
			}
		}



		int ans = 0;
		boolean isImpossible = true;
		while (!jq.isEmpty()) {
			var cur = jq.poll();
			int y = cur[0];
			int x = cur[1];
			if (y == 0 || y == r - 1 || x == 0 || x == c - 1) {
				ans = jDist[y][x] + 1;
				isImpossible = false;
				break;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (jDist[ny][nx] != -1 || board[ny][nx] != '.') continue;
				if (fDist[y][x] != -1 && jDist[y][x] + 1 >= fDist[ny][nx]) continue;
				jDist[ny][nx] = jDist[y][x] + 1;
				jq.offer(new int[]{ny, nx});
			}
		}
		if (isImpossible) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		System.out.println(ans);
	}
}
