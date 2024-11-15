import java.io.*;
import java.util.*;

// BFS, O(n^2)
public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);

		boolean[][] room = new boolean[n + 2][n + 2]; // true = light on
		boolean[][] isVisited = new boolean[n + 2][n + 2];

		Map<List<Integer>, List<int[]>> switches = new HashMap<>();
		for (int i = 0; i < m; ++i) {
			tokens = br.readLine().split(" ");
			int sy = Integer.parseInt(tokens[0]);
			int sx = Integer.parseInt(tokens[1]);
			int ey = Integer.parseInt(tokens[2]);
			int ex = Integer.parseInt(tokens[3]);
			List<Integer> key = Arrays.asList(sy, sx);
			switches.putIfAbsent(key, new ArrayList<>());
			switches.get(key).add(new int[]{ey, ex});
		}

		Queue<int[]> q = new LinkedList<>();
		isVisited[1][1] = true;
		room[1][1] = true;
		q.offer(new int[]{1, 1});
		int ans = 1;
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			List<int[]> coords = switches.get(Arrays.asList(y, x));
			if (coords != null) {
				for (var coord : coords) {
					int cy = coord[0];
					int cx = coord[1];
					if (isVisited[cy][cx]) continue;
					if (!room[cy][cx]) ++ans;
					room[cy][cx] = true;
					for (int dir = 0; dir < 4; ++dir) {
						int ccy = cy + dy[dir];
						int ccx = cx + dx[dir];
						if (ccy < 1 || ccy > n + 1 || ccx < 1 || ccx > n + 1) continue;
						if (!isVisited[ccy][ccx]) continue;
						isVisited[cy][cx] = true;
						q.offer(new int[]{cy, cx});
						break;
					}
				}
			}
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 1 || ny > n + 1 || nx < 1 || nx > n + 1) continue;
				if (room[ny][nx] != true || isVisited[ny][nx]) continue;
				isVisited[ny][nx] = true;
				q.offer(new int[]{ny, nx});
			}
		}
		System.out.println(ans);
	}
}
