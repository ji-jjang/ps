import java.util.*;

class Solution {
    
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    public int[] solution(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        
        boolean[][][] isVisited = new boolean[r][c][4];
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                for (int dir = 0; dir < 4; ++dir) {
                    if (!isVisited[i][j][dir]) {
                        ret.add(countCycleLen(i, j, dir, r, c, grid, isVisited));
                    }
                }
            }
        }
        
        int[] ans = new int[ret.size()];
        ret.sort((a, b) -> Integer.compare(a, b));
        int idx = 0;
        for (var e : ret) {
            ans[idx++] = e;
        }
        return ans;
    }
    
    int countCycleLen(int i, int j, int dir, int r, int c, String[] grid, boolean[][][] isVisited) {
    
        int cnt = 0;
        
        while (!isVisited[i][j][dir]) {
            ++cnt;
            isVisited[i][j][dir] = true;
            if (grid[i].charAt(j) == 'L') {
                dir = (dir + 3) % 4;
            }
            if (grid[i].charAt(j) == 'R') {
                dir = (dir + 1) % 4;
            }
            i = (i + dy[dir] + r) % r;
            j = (j + dx[dir] + c) % c;
        }
        return cnt;
    }
    
}