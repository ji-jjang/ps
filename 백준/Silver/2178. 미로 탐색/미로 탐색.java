import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		String[] maze = new String[r];
		int[][] dist = new int[r][c];
		for (int i = 0; i < r; ++i) 
			Arrays.fill(dist[i], -1);
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < r; ++i) {
			maze[i] = br.readLine();
		}

		q.offer(new int[]{0, 0});
		dist[0][0] = 1;
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};
		while (!q.isEmpty()) {
			var cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			for (int dir = 0; dir < 4; ++dir) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (dist[ny][nx] != -1 || maze[ny].charAt(nx) == '0') continue;
				dist[ny][nx] = dist[y][x] + 1;
				q.offer(new int[]{ny, nx});
			}
		}
		System.out.println(dist[r - 1][c - 1]);
	}
}
