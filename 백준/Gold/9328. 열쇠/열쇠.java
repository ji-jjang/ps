import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			char[][] board = new char[r + 2][c + 2];
			boolean[][] isVisited = new boolean[r + 2][c + 2];
			for (int i = 1; i <= r; ++i) {
				String line = br.readLine();
				for (int j = 1; j <= c; ++j) {
					board[i][j] = line.charAt(j - 1);
				}
			}
			String line = br.readLine();

			Set<Character> keys = new HashSet<>();
			for (int i = 0; i < line.length(); ++i) {
				if (line.charAt(i) == '0') break;
				keys.add(line.charAt(i));
			}

			sb.append(bfs(board, r, c , keys, isVisited) + "\n");
		}
		System.out.println(sb.toString());
	}

	static int bfs(char[][] board, int r, int c, Set<Character> keys, boolean[][] isVisited) {
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<>();
		Map<Character, List<int[]>> doors = new HashMap<>();

		int ans = 0;
		q.offer(new int[]{0, 0});
		isVisited[0][0] = true;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0], x = cur[1];

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny < 0 || ny > r + 1 || nx < 0 || nx > c + 1) continue;
				if (isVisited[ny][nx] || board[ny][nx] == '*') continue;

				char color = board[ny][nx];
				isVisited[ny][nx] = true;
				if (color >= 'a' && color <= 'z') {
					keys.add(color);
					char door = (char)(color - 'a' + 'A');
					if (doors.containsKey(door)) {
						for (var d : doors.get(door)) q.offer(d);
						doors.remove(door);
					}
				}
				else if (color >= 'A' && color <= 'Z') {
					char key = (char)(color - 'A' + 'a');
					if (keys.contains(key)) {
						q.offer(new int[]{ny, nx});
					} else {
						doors.putIfAbsent(color, new ArrayList<>());
						doors.get(color).add(new int[]{ny, nx});
					}
					continue;
				}
				else if (board[ny][nx] == '$') ++ans;
				q.offer(new int[]{ny, nx});
			}
		}
		return ans;
	}
}

