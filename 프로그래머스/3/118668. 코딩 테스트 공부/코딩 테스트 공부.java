import java.util.*;

class Solution {

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = -1;
        int maxCop = -1;
        for (var p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (var row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; ++i) {
            for (int j = cop; j <= maxCop; ++j) {
                if (i < maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j < maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

                for (var p : problems) {
                    if (i >= p[0] && j >= p[1]) {
                        int newAlp = Math.min(i + p[2], maxAlp);
                        int newCop = Math.min(j + p[3], maxCop);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + p[4]);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}

