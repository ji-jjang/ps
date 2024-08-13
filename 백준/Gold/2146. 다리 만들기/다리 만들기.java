import java.util.*;
import java.io.*;

// 1. 섬마다 고유 번호 부여(bfs & 1001, 1002, 1003...)
// 2. 하나씩 bfs하며, 1은 1001(계속 증가), 0인 곳은 큐에 담음
// 3. 0인 위치에서 부터 시작하여, 1이 나올떄까지 bfs(최소값 갱신, 최소값 이상으로 탐색할 경우 탐색 종료)
public class Main {

	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int seq = 1000;
		Queue<int[]> q = new LinkedList<>();
		List<int[]> l = new LinkedList<>();
		boolean[][] isVisited = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				boolean isIsland = false;
				if (board[i][j] == 1) {
					++seq;
					board[i][j] = seq;
					q.offer(new int[]{i, j});
					isIsland = true;
				}
				while (!q.isEmpty()) {
					var cur = q.poll();
					int y = cur[0];
					int x = cur[1];
					for (int dir = 0; dir < 4; ++dir) {
						int ny = y + dy[dir];
						int nx = x + dx[dir];
						if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
						if (board[ny][nx] == 0 && !isVisited[ny][nx]) {
							isVisited[ny][nx] = true;
							l.add(new int[]{ny, nx});
						}
						if (board[ny][nx] != 1) continue;
						board[ny][nx] = seq;
						q.offer(new int[]{ny, nx});
					}
				}
				if (isIsland) {
					for (var e : l) {
						bfs(e[0], e[1], n, seq, board);
					}
					l.clear();
				}
			}
		}
		System.out.println(ans);
	}

	static void bfs(int i, int j, int n, int seq, int[][] board) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[n][n];
		
		isVisited[i][j] = true;
		q.offer(new int[]{i, j, 0});
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int move = cur[2];
			if (move >= ans) break;
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
				if (isVisited[ny][nx]) continue;
				if (board[ny][nx] != 0 && board[ny][nx] != seq) {
					ans = Math.min(ans, move) + 1;
					// System.out.println(ans);
					break;
				}
				if (board[y][x] != 0) continue;
				isVisited[ny][nx] = true;
				q.offer(new int[]{ny, nx, move + 1});
			}
		}
	}
}
