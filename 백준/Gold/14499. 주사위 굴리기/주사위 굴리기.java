import java.util.*;
import java.io.*;

public class main {

	static int[][] dice = new int[4][3];
	static int[][] map;
	static list<integer> dirs = new arraylist<>();
	static int[] dy = {0, 0, 0, -1, 1};
	static int[] dx = {0, 1, -1, 0, 0};
	public static void main(string[] args) throws ioexception {

		bufferedreader br = new bufferedreader(new inputstreamreader(system.in));

		string[] tokens = br.readline().split(" ");

		int r = integer.parseint(tokens[0]);
		int c = integer.parseint(tokens[1]);
		int sy = integer.parseint(tokens[2]);
		int sx = integer.parseint(tokens[3]);
		int k = integer.parseint(tokens[4]);

		map = new int[r][c];
		for (int i = 0; i < r; ++i) {
			tokens = br.readline().split(" ");
			for (int j = 0; j < c; ++j) {
				map[i][j] = integer.parseint(tokens[j]);
			}
		}
		tokens = br.readline().split(" ");
		for (int i = 0; i < k; ++i) {
			dirs.add(integer.parseint(tokens[i]));
		}
		
		stringbuilder sb = new stringbuilder();
		for (var dir : dirs) {
			if (sy + dy[dir] >= r || sy + dy[dir] < 0 || sx + dx[dir] >= c || sx + dx[dir] < 0) continue;
			sy += dy[dir];
			sx += dx[dir];
			if (dir == 1) rotate_east();
			else if (dir == 2) rotate_west();
			else if (dir == 3) rotate_north();
			else rotate_south();

			if (map[sy][sx] == 0) {
				map[sy][sx] = dice[3][1];
			} else {
				dice[3][1] = map[sy][sx];
				map[sy][sx] = 0;
			}
			sb.append(dice[1][1] + "\n");
		}
		system.out.println(sb);
	}

	static void rotate_north() {
		int[] tmp = new int[4];
		for (int row = 0; row < 4; ++row) {
			tmp[row] = dice[row][1];
		}
		for (int i = 1; i < 4; ++i) {
			dice[i - 1][1] = tmp[i];
		}
		dice[3][1] = tmp[0];
	}

	static void rotate_east() {
		int[] tmp = new int[4];
		tmp[0] = dice[1][0];
		tmp[1] = dice[1][1];
		tmp[2] = dice[1][2];
		tmp[3] = dice[3][1];

		dice[1][0] = tmp[3];
		dice[1][1] = tmp[0];
		dice[1][2] = tmp[1];
		dice[3][1] = tmp[2];
	}

	static void rotate_south() {
		int[] tmp = new int[4];
		for (int row = 0; row < 4; ++row) {
			tmp[row] = dice[row][1];
		}
		for (int i = 0; i < 3; ++i) {
			dice[i + 1][1] = tmp[i];
		}
		dice[0][1] = tmp[3];
	}
	
	static void rotate_west() {
		int[] tmp = new int[4];
		tmp[0] = dice[1][0];
		tmp[1] = dice[1][1];
		tmp[2] = dice[1][2];
		tmp[3] = dice[3][1];


		dice[1][0] = tmp[1];
		dice[1][1] = tmp[2];
		dice[1][2] = tmp[3];
		dice[3][1] = tmp[0];
	}
}
