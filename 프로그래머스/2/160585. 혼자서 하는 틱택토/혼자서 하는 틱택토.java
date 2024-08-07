import java.util.*;

class Solution {
    public int solution(String[] board) {
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                b[i][j] = board[i].charAt(j);
            }
        }
        int oCnt = count('O', b);
        int xCnt = count('X', b);
        
        int ans = 1;
        if (xCnt > oCnt) ans = 0;
        if ((oCnt - xCnt) > 1) ans = 0; 
        if (isWin('O', b) && isWin('X', b)) ans = 0;
        if (isWin('O', b) && (oCnt - xCnt != 1)) ans = 0;
        if (isWin('X', b) && (oCnt != xCnt)) ans = 0;
        
        return ans;
    }
    boolean isWin(char c, char[][] board) {
        for (int row = 0; row < 3; ++row) {
            if (board[row][0] == c && board[row][1] == c && board[row][2] == c)
                return true;
        }
        for (int col = 0; col < 3; ++col) {
            if (board[0][col] == c && board[1][col] == c && board[2][col] == c)
                return true;
        }

        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            return true;
        }
        return false;
    }

    int count(char c, char[][] board) {
        int cnt = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == c) ++cnt;
            }
        }
        return cnt;
    }
}