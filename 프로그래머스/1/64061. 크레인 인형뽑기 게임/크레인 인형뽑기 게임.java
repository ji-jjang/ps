import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int n = board.length;
        
        int ans = 0;
        for (var col : moves) {
            --col;
            for (int i = 0; i < n; ++i) {
                if (board[i][col] != 0) {
                    if (!s.isEmpty() && s.peek() == board[i][col]) {
                        s.pop();
                        ans += 2;
                    }
                    else {
                        s.push(board[i][col]);
                    }
                    board[i][col] = 0;
                    break;
                }
            }
        }
        return ans;
    }
}