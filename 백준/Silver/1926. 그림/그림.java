import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] grid = new int[r][c];
		boolean[][] isVisited = new boolean[r][c];

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int pictureCnt = 0;
		int maxSize = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {

				if (!isVisited[i][j] && grid[i][j] == 1) {
					++pictureCnt;
					isVisited[i][j] = true;
					q.offer(new int[]{i, j});

					int cnt = 0;
					while (!q.isEmpty()) {
						++cnt;
						maxSize = Math.max(maxSize, cnt);
						var cur = q.poll();
						int y = cur[0];
						int x = cur[1];
						for (int dir = 0; dir < 4; ++dir) {
							int ny = y + dy[dir];
							int nx = x + dx[dir];
							if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
							if (isVisited[ny][nx] || grid[ny][nx] == 0) continue;
							isVisited[ny][nx] = true;
							q.offer(new int[]{ny, nx});
						}
					}
				}
			}
		}
		System.out.println(pictureCnt + "\n" + maxSize);
	}
}
