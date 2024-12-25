import java.util.*;
import java.io.*;

public class Main {

	static int r, c;
	static int sy, sx, sdir;
	static int[][] room;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().split(" ");
		r = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);
		room = new int[r][c];

		tokens = br.readLine().split(" ");
		sy = Integer.parseInt(tokens[0]);
		sx = Integer.parseInt(tokens[1]);
		sdir = Integer.parseInt(tokens[2]);

		for (int i = 0; i < r; ++i) {
			tokens = br.readLine().split(" ");
			for (int j = 0; j < c; ++j) {
				room[i][j] = Integer.parseInt(tokens[j]);
			}
		}

		Queue<int[]> q = new LinkedList<>(); // y, x, dir
		q.offer(new int[]{sy, sx, sdir});

		int ans = 0;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int dir = cur[2];
			if (room[y][x] == 0) {
				++ans;
				room[y][x] = 2;
			}
			if (isCleaned(y, x)) {
				int newDir = (dir + 2) % 4;
				int ny = y + dy[newDir];
				int nx = x + dx[newDir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) 
					continue;
				if (room[ny][nx] != 1) {
					q.offer(new int[]{ny, nx, dir});
				}
			} else {
				for (int i = 0; i < 4; ++i) {
					dir -= 1;
					if (dir < 0) {
						dir = 3;
					}
					int ny = y + dy[dir];
					int nx = x + dx[dir];
					if (ny < 0 || ny >= r || nx < 0 || nx >= c) 
						continue;
					if (room[ny][nx] == 0) {
						q.offer(new int[]{ny, nx, dir});
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

	static boolean isCleaned(int y, int x) {

		for (int dir = 0; dir < 4; ++dir) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) 
				continue;
			if (room[ny][nx] == 0)
				return false;
		}
		return true;
	}
}
