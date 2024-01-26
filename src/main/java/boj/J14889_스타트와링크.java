package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J14889_스타트와링크 {
    static int n;
    static int[][] synergy = new int[24][24];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                synergy[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[] isSelected = new boolean[n + 1];
        dfs(0, 1, isSelected);
        System.out.println(ans);
    }

    static void dfs(int depth, int start, boolean[] isSelected) {
        if (depth == n / 2) {
            int sumA = 0, sumB = 0;
            for (int i = 1; i <= n; ++i) {
                for (int j = i + 1; j <= n; ++j) {
                    if (isSelected[i] && isSelected[j])
                        sumA += synergy[i][j] + synergy[j][i];
                    else if (!isSelected[i] && !isSelected[j])
                        sumB += synergy[i][j] + synergy[j][i];
                }
            }
            ans = Math.min(ans, Math.abs(sumA - sumB));
            return;
        }
        for (int i = start; i <= n; ++i) {
            isSelected[i] = true;
            dfs(depth + 1, i + 1, isSelected);
            isSelected[i] = false;
        }
    }
}
