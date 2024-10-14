import java.io.*;
import java.util.*;

public class Main {

	static int[][][] board = new int[5][5][5];
	static int[][][][] rotatedBoard = new int[5][4][5][5];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; ++k) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		rotatedBoard = new int[5][4][5][5];
		for (int i = 0; i < 5; ++i) {
			for (int rot = 0; rot < 4; ++rot) {
				rotatedBoard[i][rot] = rotateBoard(board[i], rot);
			}
		}
		dfs(0, new boolean[5], new int[5]);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	public static int[][] rotateBoard(int[][] board, int rot) {
    int[][] tmp = new int[5][5];
    int[][] result = new int[5][5];

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				result[i][j] = board[i][j];
			}
		}

    for (int r = 0; r < rot; ++r) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                tmp[j][5 - i - 1] = result[i][j];
            }
        }
        int[][] temp = result;
        result = tmp;
        tmp = temp;
    }
    return result;
}


	public static void dfs(int depth, boolean[] isVisited, int[] boardSeq) {

		if (depth == 5) {
			dfs2(0, boardSeq, new int[5]);
			return;
		}
		for (int i = 0; i < 5; ++i) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			boardSeq[depth] = i;
			dfs(depth + 1, isVisited, boardSeq);
			isVisited[i] = false;
		}
	}

	public static void dfs2(int depth, int[] boardSeq, int[] rot) {

		if (depth == 5) {
			bfs(boardSeq, rot);
			return;
		}
		for (int i = 0; i < 4; ++i) {
			rot[depth] = i;
			dfs2(depth + 1, boardSeq, rot);
		}
	}

	public static void bfs(int[] boardSeq, int[] rot) {

		int[][][] maze = new int[5][5][5];
		for (int i = 0; i < 5; ++i) {
			maze[i] = rotatedBoard[boardSeq[i]][rot[i]];
		}

		if (maze[0][0][0] == 0 || maze[4][4][4] == 0) {
			return;
		}
		boolean[][][] isVisited = new boolean[5][5][5];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0, 0, 0});
		isVisited[0][0][0] = true;
		int steps = 0;

		int[] dz = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dx = {0, 0, 0, 0, 1, -1};

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int z = cur[0];
			int y = cur[1];
			int x = cur[2];
			int cnt = cur[3];

			if (z == 4 && y == 4 && x == 4) {
				ans = Math.min(ans, cnt);
				return;
			}

			for (int dir = 0; dir < 6; ++dir) {
				int nz = z + dz[dir];
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5)
						continue;
				if (isVisited[nz][ny][nx] || maze[nz][ny][nx] == 0)
						continue;
				isVisited[nz][ny][nx] = true;
				q.add(new int[]{nz, ny, nx, cnt + 1});
			}
		}
	}
}
