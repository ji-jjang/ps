package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J12100_2048easy {
    static int n;
    static int[][] board = new int[24][24];
    static int[][] cBoard = new int[24][24];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, new ArrayList<>());
        System.out.println(ans);
    }

    static void dfs(int depth, ArrayList<Integer> seq) {
        if (depth == 5) {
            for (int i = 0; i < n; i++)
                System.arraycopy(board[i], 0, cBoard[i], 0, n);
            int restoreCnt = 4;
            for (int rotation : seq) {
                rotate(rotation);
                push();
                restoreCnt -= rotation;
                rotate(restoreCnt);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    ans = Math.max(ans, cBoard[i][j]);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            seq.add(i);
            dfs(depth + 1, seq);
            seq.remove(seq.size() - 1);
        }
    }

    static void rotate(int cnt) {
        if (cnt == 0 || cnt == 4)
            return;
        while (cnt-- > 0) {
            int[][] tmp = new int[24][24];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    tmp[j][n - i - 1] = cBoard[i][j];
            }
            for (int i = 0; i < n; i++)
                System.arraycopy(tmp[i], 0, cBoard[i], 0, n);
        }
    }

    static void push() {
        for (int col = 0; col < n; col++) {
            int[] tmp = new int[24];
            int idx = 0;
            for (int row = 0; row < n; row++) {
                if (cBoard[row][col] == 0) continue;
                if (tmp[idx] == 0) tmp[idx] = cBoard[row][col];
                else if (tmp[idx] != cBoard[row][col]) tmp[++idx] = cBoard[row][col];
                else tmp[idx++] *= 2;
            }
            for (int i = 0; i < n; i++) cBoard[i][col] = tmp[i];
        }
    }
}
