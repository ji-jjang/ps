import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int r, c;
	static int[][] room;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		room = new int[r][c];
		
		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken());
		int sx = Integer.parseInt(st.nextToken());
		int sdir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{sy, sx, sdir});

		int ans = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int dir = cur[2];

			if (room[y][x] == 0) {
				room[y][x] = 2;
				++ans;
			}
			if (!hasDirtyRoom(y, x)) {
				int newDir = (dir + 2) % 4;
				int ny = y + dy[newDir];
				int nx = x + dx[newDir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (room[ny][nx] == 1) continue;
				q.add(new int[]{ny, nx, dir});
			} else {
				dir -= 1;
				if (dir < 0)
					dir = 3;
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (room[ny][nx] == 0)
					q.add(new int[]{ny, nx, dir});
				else
					q.add(new int[]{y, x, dir});

			}
		}
		System.out.println(ans);
	}

	static boolean hasDirtyRoom(int sy, int sx) {

		for (int dir = 0; dir < 4; ++dir) {
			int ny = sy + dy[dir];
			int nx = sx + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			if (room[ny][nx] == 0)
				return true;
		}
		return false;
	}
}
