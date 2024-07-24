class Solution {
    public int[] solution(int n) {
        int[][] board = new int[n][n];
        int r = -1, c = 0;
        int cnt = 1;
        int dir = 0; 

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (dir == 0) {
                    ++r;
                } else if (dir == 1) {
                    ++c;
                } else if (dir == 2) {
                    --r;
                    --c;
                }
                board[r][c] = cnt++;
            }
            dir = (dir + 1) % 3;
        }

        int[] ans = new int[cnt - 1];
        cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                ans[cnt++] = board[i][j];
            }
        }
        return ans;
    }
}