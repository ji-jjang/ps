import java.io.*;
import java.util.*;

// BFS, O(r * c)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int r = Integer.parseInt(tokens[0]);
		int c = Integer.parseInt(tokens[1]);
		int p = Integer.parseInt(tokens[2]);

		int[] spreads = new int[p + 1];
		char[][] board = new char[r][c];
		List<Queue<int[]>> q = new ArrayList<>(); // y, x, moveCount
		Queue<int[]> tmp = new LinkedList<>(); // y, x
		for (int i = 0; i < p + 1; ++i) {
			q.add(new LinkedList<>());
		}

		tokens = br.readLine().split(" ");
		for (int i = 1; i < p + 1; ++i) {
			spreads[i] = Integer.parseInt(tokens[i - 1]);
		}
		for (int i = 0; i < r; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line[j];
				if (board[i][j] != '.' && board[i][j] != '#') {
					q.get(board[i][j] - '0').offer(new int[]{i, j, spreads[board[i][j] - '0']});
				}
			}
		}
		while (true) {
			boolean canSpread = false;
			for (int i = 1; i <= p; ++i) {
				while (!q.get(i).isEmpty()) {
					var cur = q.get(i).poll();
					int y = cur[0];
					int x = cur[1];
					int cnt = cur[2];
					char ch = board[y][x];
					if (cnt < 1) {
						tmp.offer(new int[]{y, x});
						continue;
					}
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
						if (board[ny][nx] != '.') continue;
						canSpread = true;
						board[ny][nx] = ch;
						q.get(i).offer(new int[]{ny, nx, cnt - 1});
					}
				}
				while (!tmp.isEmpty()) {
					var cur = tmp.poll();
					q.get(i).offer(new int[]{cur[0], cur[1], spreads[i]});
				}
			}
			if (!canSpread) break;
		}
		int[] cnt = new int[p + 1];
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (board[i][j] != '.' && board[i][j] != '#') 
					++cnt[board[i][j] - '0'];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= p; ++i) {
			sb.append(cnt[i] + " ");
		}
		System.out.println(sb);
	}
}
