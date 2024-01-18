package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J18808_스티커붙이기 {
    static int n, m, k;
    static int[][] note = new int[44][44];
    static int[][] sticker = new int [14][14];
    static int r, c;
    static void rotate() {
        int[][] temp = new int[14][14];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                temp[j][r - i - 1] = sticker[i][j];
            }
        }
        int tmp = r;
        r = c;
        c = tmp;
        for (int i = 0; i < r; i++)
            System.arraycopy(temp[i], 0, sticker[i], 0, c);
    }

    static boolean putSticker(int y, int x) {
        for (int i = y; i < y + r; ++i) {
            for (int j = x; j < x + c; ++j) {
                if (note[i][j] == 1 && sticker[i - y][j - x] == 1) {
                    return false;
                }
            }
        }
        for (int i = y; i < y + r; ++i) {
            for (int j = x; j < x + c; ++j) {
                if (note[i][j] == 0) {
                    note[i][j] = sticker[i - y][j - x];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean isAttached = false;
            for (int ro = 0; ro < 4; ++ro) {
                if (ro != 0)
                    rotate();
                if (isAttached)
                    break;
                for (int i = 0; i <= n - r; i++) {
                    if (isAttached) break;
                    for (int j = 0; j <= m - c; j++) {
                        if (putSticker(i, j)) {
                            isAttached = true;
                            break;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (note[i][j] == 1)
                    ++ans;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
