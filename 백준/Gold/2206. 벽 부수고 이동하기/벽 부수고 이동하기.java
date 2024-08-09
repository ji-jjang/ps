import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] board = new int[r][c];
		int[][][] dist = new int[r][c][2];

		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j) - '0';
				dist[i][j][0] = -1;
				dist[i][j][1] = -1;
			}
		}

		boolean isArrived = false;
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>(); // y, x, breakCnt

		dist[0][0][0] = 1;
		q.offer(new int[]{0, 0, 0});	
		int ans = -1;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int cnt = cur[2];
			if (y == r - 1 && x == c - 1) {
				ans = dist[y][x][cnt];
				break;
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (dist[ny][nx][cnt] != -1) continue;
				if (board[ny][nx] == 1 && cnt < 1) {
					if (dist[ny][nx][cnt + 1] != -1) continue;
					dist[ny][nx][cnt + 1] = dist[y][x][cnt] + 1;
					q.offer(new int[]{ny, nx, cnt + 1});
				}
				if (board[ny][nx] == 0) {
					dist[ny][nx][cnt] = dist[y][x][cnt] + 1;
					q.offer(new int[]{ny, nx, cnt});
				}
			}
		}
		System.out.println(ans);
	}
}
