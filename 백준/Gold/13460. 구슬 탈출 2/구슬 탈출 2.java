import java.io.*;
import java.util.*;

public class Main {

	static char[][] board;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[] red = {0 ,0};
	static int[] blue = {0, 0};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					board[i][j] = '.';
				} else if (board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					board[i][j] = '.';
				}
			}
		}

		int[] seq = new int[10];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (1 << (2 * 10)); ++i) {
			int cur = i;
			for (int j = 0; j < 10; ++j) {
				seq[j] = cur % 4;
				cur /= 4;
			}
			start(seq);
		}
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void start(int[] seq) {

		int ry = red[0];
		int rx = red[1];
		int by = blue[0];
		int bx = blue[1];
		boolean isEnd = false, isSuccess = false;
		int rrot = 0;
		for (int rot = 0; rot < 10; ++rot) {
			if (rot >= ans)
				break;
			isEnd = false;
			isSuccess = false;
			int dir = seq[rot];

			int rry = ry;
			int rrx = rx;
			int bby = by;
			int bbx = bx;
			while (board[rry + dy[dir]][rrx + dx[dir]] == '.') {
				rry += dy[dir];
				rrx += dx[dir];
			}
			while (board[bby + dy[dir]][bbx + dx[dir]] == '.') {
				bby += dy[dir];
				bbx += dx[dir];
			}

			if (board[rry + dy[dir]][rrx + dx[dir]] == '#' && board[bby + dy[dir]][bbx + dx[dir]] == '#') {
				if (rry == bby && rrx == bbx) {
					if (dir == 0) {
						if (ry > by) {
							++rry;
						} else {
							++bby;
						}
					} else if (dir == 1) {
						if (rx < bx) {
							--rrx;
						} else {
							--bbx;
						}
					} else if (dir == 2) {
						if (ry > by) {
							--bby;
						}
						else {
							--rry;
						}
					} else if (dir == 3) {
						if (rx > bx) {
							++rrx;
						} else {
							++bbx;
						}
					}
				}
				ry = rry;
				rx = rrx;
				by = bby;
				bx = bbx;
			}
			if (board[bby + dy[dir]][bbx + dx[dir]] == 'O') {
				isEnd = true;
				break;
			}
			if (board[rry + dy[dir]][rrx + dx[dir]] == 'O') {
				isSuccess = true;
				rrot = rot;
				break;
			}
		}
		if (isEnd) {
			return;
		}
		if (isSuccess) {
			ans = Math.min(ans, rrot + 1);
			return ;
		}
	}
}
