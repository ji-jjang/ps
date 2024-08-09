import java.util.*;

class Solution {

	int[] dy = {-1, 0, 1, 0};
	int[] dx = {0, 1, 0, -1};
	
	public int solution(int[][] board, int[] aloc, int[] bloc) {
		int r = board.length;
		int c = board[0].length;
		return solve(aloc[0], aloc[1], bloc[0], bloc[1], r, c, board, new boolean[r][c]);
	}

	int solve(int cy, int cx, int oy, int ox, int r, int c, int[][] board, boolean[][] isVisited){
		if (isVisited[cy][cx]) return 0;    

		int ret = 0;
		for (int dir = 0; dir < 4; dir++){
			int ny = cy + dy[dir];
			int nx = cx + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			if (isVisited[ny][nx] || board[ny][nx] == 0) continue;

			isVisited[cy][cx] = true;
			int val = solve(oy, ox, ny, nx, r, c, board, isVisited) + 1;

			isVisited[cy][cx] = false;        

			if (ret % 2 == 0 && val % 2 == 1) ret = val;
			else if (ret % 2 == 0 && val % 2 == 0) ret = Math.max(ret, val);
			else if (ret % 2 == 1 && val % 2 == 1) ret = Math.min(ret, val);
		}
		return ret;
	}
}

