import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        boolean[][] isVisited = new boolean[n][n];
        
        isVisited[h][w] = true;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        int ans = 0;
        String color = board[h][w];
        for (int dir = 0; dir < 4; ++dir) {
            int ny = h + dy[dir];
            int nx = w + dx[dir];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if (!board[ny][nx].equals(color)) continue;
            ++ans;
        }
 
        return ans;
    }
}