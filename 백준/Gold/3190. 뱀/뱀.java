import java.io.*;
import java.util.*;

public class Main {

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n, k;
	static int[][] board;
	static Map<Integer, String> m = new HashMap<>();

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		board = new int[n][n];
		for (int i = 0; i < k; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y - 1][x - 1] = 2;
		}
		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		System.out.println(start());
	}

	public static int start() {

		int time = 0;
		int hy = 0;
		int hx = 0;
		int dir = 1;
		Deque<int[]> snake = new LinkedList<>();
		snake.offerFirst(new int[]{hy, hx});
		board[hy][hx] = 1;

		while (true) {
			++time;
			int ny = hy + dy[dir];
			int nx = hx + dx[dir];

			if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] == 1) 
				break;

			if (board[ny][nx] == 2) {
				board[ny][nx] = 1;
				snake.offerFirst(new int[]{ny, nx});
			} else {
				board[ny][nx] = 1;
				snake.offerFirst(new int[]{ny, nx});
				var tail = snake.pollLast();
				board[tail[0]][tail[1]] = 0;
			}

			hy = ny;
			hx = nx;

			if (m.containsKey(time)) {
				String c = m.get(time);
				if (c.equals("D")) {
					dir = (dir + 1) % 4;
				} else if (c.equals("L")) {
					dir = (dir + 3) % 4;
				}
			}
		}

		return time;
	}
}
