class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        
        int ySt = x, yEn = x;
        int xSt = y, xEn = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int comm = queries[i][0];
            int dx = queries[i][1];
            
            if (comm == 0) {
                if (xSt != 0) xSt += dx;
                xEn = Math.min(m - 1, xEn + dx);
            } else if (comm == 1) {
                xSt = Math.max(0, xSt - dx);
                if (xEn != m - 1) xEn -= dx;
            } else if (comm == 2) {
                if (ySt != 0) ySt += dx;
                yEn = Math.min(n - 1, yEn + dx);
            } else if (comm == 3) {
                ySt = Math.max(0, ySt - dx);
                if (yEn != n - 1) yEn -= dx;
            }

            if (ySt > yEn || xSt > xEn) {
                return 0;
            }
        }

        return 1L * (yEn - ySt + 1) * (xEn - xSt + 1);
    }
}