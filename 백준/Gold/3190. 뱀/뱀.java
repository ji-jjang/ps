import java.util.*;
import java.io.*;

public class Main {

	static int[][] map; // 0 empty, 1 apple, 2 snake(collision)
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; ++i) {
			String[] tokens = br.readLine().split(" ");
			int y = Integer.parseInt(tokens[0]) - 1;
			int x = Integer.parseInt(tokens[1]) - 1;
			map[y][x] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		Map<Integer, Character> dirs = new HashMap<>();
		for (int i = 0; i < l; ++i) {
			String[] tokens = br.readLine().split(" ");
			dirs.put(Integer.parseInt(tokens[0]), tokens[1].charAt(0));
		}

		Deque<int[]> snake = new LinkedList<>();
		int dir = 0;
		map[0][0] = 2;
		snake.add(new int[]{0, 0});
		int ans = 1;
		while (true) {
			var pos = snake.peekFirst();
			int y = pos[0];
			int x = pos[1];
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (dirs.containsKey(ans)) {
				char c = dirs.get(ans);
				if (c == 'D') {
					dir = (dir + 1) % 4;
				}
				else if (c == 'L') {
					dir -= 1;
					if (dir < 0) dir = 3;
				}
			}
			if (ny < 0 || ny >= n || nx < 0 || nx >= n)
				break;
			if (map[ny][nx] == 2)
				break;
			snake.addFirst(new int[]{ny, nx});
			if (map[ny][nx] == 0) { 
				var cur = snake.pollLast();
				map[cur[0]][cur[1]] = 0;
			}
			map[ny][nx] = 2;
			++ans;
		}
		System.out.println(ans);
	}
}
