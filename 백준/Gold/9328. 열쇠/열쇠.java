import java.io.*;
import java.util.*;

// BFS, O(t * (r * c + D * L))
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			Map<Character, List<int[]>> doors = new HashMap<>();
			Set<Character> keys = new HashSet<>();
			String[] tokens = br.readLine().split(" ");
			int r = Integer.parseInt(tokens[0]);
			int c = Integer.parseInt(tokens[1]);

			char[][] board = new char[r + 2][c + 2];
			boolean[][] isVisited = new boolean[r + 2][c + 2];
			for (int i = 0; i < r + 2; ++i) {
				Arrays.fill(board[i], '.');
			}
			for (int i = 1; i < r + 1; ++i) {
				char[] line = br.readLine().toCharArray();
				for (int j = 1; j < c + 1; ++j) {
					board[i][j] = line[j - 1];
				}
			}
			char[] ks = br.readLine().toCharArray();
			for (char key : ks) {
				if (key == '0') break;
				keys.add(key);
			}

			Queue<int[]> q = new LinkedList<>();
			isVisited[0][0] = true;
			q.offer(new int[]{0, 0});
			int ans = 0;
			while (!q.isEmpty()) {
				var cur = q.poll();
				int y = cur[0];
				int x = cur[1];
				for (int dir = 0; dir < 4; ++dir) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (ny < 0 || ny > r + 1 || nx < 0 || nx > c + 1) continue;

					if (isVisited[ny][nx] || board[ny][nx] == '*') continue;

					isVisited[ny][nx] = true;
					if (board[ny][nx] >= 'a' && board[ny][nx] <= 'z') {
						keys.add(board[ny][nx]);
						char door = (char)(board[ny][nx] - 'a' + 'A');
						if (doors.containsKey(door)) {
							for (var pos : doors.get(door))
								q.offer(new int[]{pos[0], pos[1]});
							doors.remove(door);
						}
					}
					else if (board[ny][nx] >= 'A' && board[ny][nx] <= 'Z') {
						char key = (char)(board[ny][nx] - 'A' + 'a');
						if (!keys.contains(key)) {
							doors.putIfAbsent(board[ny][nx], new ArrayList<>());
							doors.get(board[ny][nx]).add(new int[]{ny, nx});
							continue;
						}
					}
					else if (board[ny][nx] == '$') {
						++ans;
					}
					q.offer(new int[]{ny, nx});
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
