import java.util.*;
import java.io.*;

public class Main {

	static int r, c;
	static char[][] board;
	static char[][] copy;
	static int[] sr, sb;
	static int[] cr, cb;
	static int ans = Integer.MAX_VALUE;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0 , -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		r = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);
		board = new char[r][c];
		copy = new char[r][c];

		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j];
				if (board[i][j] == 'R') {
					sr = new int[]{i, j};
					board[i][j] = '.';
				} else if (board[i][j] == 'B') {
					sb = new int[]{i, j};
					board[i][j] = '.';
				}
			}
		}

		dfs(0, new ArrayList<>());

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}

	static void dfs(int depth, List<Integer> selected) {
		if (depth == 10) {
			for (int i = 0; i < r; ++i) {
				for (int j = 0; j < c; ++j) {
					copy[i][j] = board[i][j];
				}
			}
			cr = sr;
			cb = sb;
			for (int i = 0; i < selected.size(); ++i) {
				int ret = move(selected.get(i));
				if (ret == 0) { // fail
					break;
				}
				else if (ret == 1) { // success
					ans = Math.min(ans, i + 1);
				}
				// 2 continue;
			}
			return;
		}
		for (int dir = 0; dir < 4; ++dir) {
			selected.add(dir);
			dfs(depth + 1, selected);
			selected.remove(selected.size() - 1);
		}
	}

	static int move(int dir) {

		boolean redArrive = false;
		boolean blueArrive = false;
		int ry = cr[0];
		int rx = cr[1];
		int by = cb[0];
		int bx = cb[1];
		while (copy[ry + dy[dir]][rx + dx[dir]] != '#') {
			if (copy[ry + dy[dir]][rx + dx[dir]] == 'O') {
				redArrive = true;
				break;
			}
			ry += dy[dir];
			rx += dx[dir];
		}

		while (copy[by + dy[dir]][bx + dx[dir]] != '#') {
			if (copy[by + dy[dir]][bx + dx[dir]] == 'O') {
				blueArrive = true;
				break;
			}
			by += dy[dir];
			bx += dx[dir];
		}
		if (redArrive && !blueArrive) {
			return 1;
		}
		else if (!redArrive && blueArrive) {
			return 0;
		}
		else if (redArrive && blueArrive) {
			return 0;
		}

		if (ry == by && rx == bx) {
			if (dir == 0) {
				if (cr[0] < cb[0])
					++by;
				else
					++ry;
			} else if (dir == 1) {
				if (cr[1] < cb[1]) 
					--rx;
				else
					--bx;
			} else if (dir == 2) {
				if (cr[0] < cb[0])
					--ry;
				else
					--by;
			} else if (dir == 3) {
				if (cr[1] < cb[1]) 
					++bx;
				else
					++rx;
			}
		}
		cr = new int[]{ry, rx};
		cb = new int[]{by, bx};
		return 2;
	}
}
