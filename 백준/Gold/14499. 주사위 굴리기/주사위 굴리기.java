import java.io.*;
import java.util.*;

public class Main {

	static int[][] dice = new int[4][3];
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] dx = {0, 1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		for (int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; ++i) {
			int dir = Integer.parseInt(st.nextToken());
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			move(dir);
			y = ny;
			x = nx;
			if (map[y][x] == 0) {
				map[y][x] = dice[3][1];
			}
			else {
				dice[3][1] = map[y][x];
				map[y][x] = 0;
			}
			sb.append(dice[1][1] + "\n");
		}
		System.out.println(sb);
	}

	public static void move(int dir) {

		int[][] tmp = new int[4][3];
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j) {
				tmp[i][j] = dice[i][j];
			}
		}

		if (dir == 1) {
			dice[1][0] = tmp[3][1];
			dice[1][1] = tmp[1][0];
			dice[1][2] = tmp[1][1];
			dice[3][1] = tmp[1][2];
		} else if (dir == 2) {
			dice[1][0] = tmp[1][1];
			dice[1][1] = tmp[1][2];
			dice[1][2] = tmp[3][1];
			dice[3][1] = tmp[1][0];
		} else if (dir == 3) {
			dice[0][1] = tmp[1][1];
			dice[1][1] = tmp[2][1];
			dice[2][1] = tmp[3][1];
			dice[3][1] = tmp[0][1];
		} else {
			dice[0][1] = tmp[3][1];
			dice[1][1] = tmp[0][1];
			dice[2][1] = tmp[1][1];
			dice[3][1] = tmp[2][1];
		}
	}
}
