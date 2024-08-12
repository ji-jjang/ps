import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int n = line.length;
        
        List<int[]> meet = new ArrayList<>();
 
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int A = line[i][0];
                int B = line[i][1];
                int E = line[i][2];
                int C = line[j][0];
                int D = line[j][1];
                int F = line[j][2];
                
                long deltaY = 1L * A * D - 1L * B * C;
                long deltaX1 = 1L * B * F - 1L * E * D;
                long deltaX2 = 1L * E * C - 1L * A * F;
                if (deltaY == 0) continue; 

                if (deltaX1 % deltaY == 0 && deltaX2 % deltaY == 0) {
                    int x = (int) (deltaX1 / deltaY);
                    int y = (int) (deltaX2 / deltaY);
                    meet.add(new int[]{x, y});
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }
        int xLen = maxX - minX + 1;
        int yLen = maxY - minY + 1;
        char[][] board = new char[yLen][xLen];
        for (int i = 0; i < yLen; ++i) 
            Arrays.fill(board[i], '.');

        for (var e : meet) {
            board[maxY - e[1]][e[0] - minX] = '*';
        }

        String[] ans = new String[yLen];
        for (int i = 0; i < yLen; ++i) {
            ans[i] = new String(board[i]);
        }
        return ans;
    }
}