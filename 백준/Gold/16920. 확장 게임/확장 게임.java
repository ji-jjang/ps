import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[] step = new int[p + 1];
		char[][] board = new char[r][c];
		boolean[][] isVisited = new boolean[r][c];
		List<Queue<int[]>> q = new ArrayList<>();; // y, x, moveCount
		for (int i = 0; i <= p + 1; ++i)
			q.add(new LinkedList<>());
		Queue<int[]> tracker = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= p; ++i) {
			step[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < r; ++i) {
			String line = br.readLine();
			for (int j = 0; j < c; ++j) {
				board[i][j] = line.charAt(j);
				if (board[i][j] >= '0' && board[i][j] <= '9') {
					q.get(board[i][j] - '0').offer(new int[]{i, j, step[board[i][j] - '0']});
				}
			}
		}

		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		while (true) {
			boolean canMove = false;
			for (int i = 1; i <= p; ++i) {
				while (!q.get(i).isEmpty()) {
					var cur = q.get(i).poll();
					int y = cur[0];
					int x = cur[1];
					int cnt = cur[2];
					char u = board[y][x];
					if (cnt < 1) {
						tracker.offer(new int[]{y, x});
						continue;
					}
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
						if (board[ny][nx] != '.') continue;
						canMove = true;
						board[ny][nx] = u;
						q.get(i).offer(new int[]{ny, nx, cnt - 1});
					}
				}
				while (!tracker.isEmpty()) {
					var cur = tracker.poll();
					int y = cur[0];
					int x = cur[1];
					q.get(i).offer(new int[]{y, x, step[i]});
				}
			}
			if (!canMove) break;
		}

		int[] cnt = new int[p + 1];
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					++cnt[board[i][j] - '0'];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= p; ++i) {
			sb.append(cnt[i] + " ");
		}
		System.out.println(sb);
	}
}

// 하나의 큐만 사용하게 되면, 거리가 1이 아닐 때도 번갈아가며 진행된다는 문제
