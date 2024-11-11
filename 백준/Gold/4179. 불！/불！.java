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

		Queue<int[]> jq = new LinkedList<>();
		Queue<int[]> fq = new LinkedList<>();
		int[][] fDist = new int[r][c];
		for (int i = 0; i < r; ++i) 
			Arrays.fill(fDist[i], -1);
		int[][] jDist = new int[r][c];
		for (int i = 0; i < r; ++i) 
			Arrays.fill(jDist[i], -1);

		char[][] board = new char[r][c];
		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {

				board[i][j] = line[j];
				if (line[j] == 'J') {
					jq.offer(new int[]{i, j});
					board[i][j] = '.';
					jDist[i][j] = 0;
				}
				else if (line[j] == 'F') {
					fq.offer(new int[]{i, j});
					board[i][j] = '.';
					fDist[i][j] = 0;
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

		int ans = 0;
		boolean isEscape = false;
		while (!jq.isEmpty()) {
			var cur = jq.poll();
			int y = cur[0];
			int x = cur[1];
			if (y == 0 || y == r - 1 || x == 0 || x == c - 1) {
				ans = jDist[y][x] + 1;
				isEscape = true;
				break;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (board[ny][nx] != '.' || jDist[ny][nx] != -1) continue;
				if (fDist[ny][nx] != -1 && fDist[ny][nx] <= jDist[y][x] + 1) continue;
				jDist[ny][nx] = jDist[y][x] + 1;
				jq.offer(new int[]{ny, nx});
				++ans;
			}
		}
		if (!isEscape) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		System.out.println(ans);
	}
}
