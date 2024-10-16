import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, l;
    static int[][] map = new int[104][104];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        checkRow();
        rotate();
        checkRow();
        System.out.println(ans);
        br.close();
    }
    static void checkRow() {
        for (int row = 0; row < n; ++row) {
            int flat = 0;
            int prev = map[row][0];
            boolean[] isBridge = new boolean[n];
            for (int col = 0; col < n; ++col) {
                if (Math.abs(map[row][col] - prev) > 1)
                    break;
                if (prev > map[row][col]) {
                    int nCol = col;
                    int nFlat = 0;
                    int nH = map[row][col];
                    while (nCol < n) {
                        if (nFlat == l || nH != map[row][nCol])
                            break;
                        isBridge[nCol] = true;
                        ++nFlat;
                        ++nCol;
                    }
                    if (nFlat < l)
                        break;
                    flat = 0;
                } else if (prev < map[row][col]) {
                    if (flat < l)
                        break;
                    flat = 0;
                }
                if (!isBridge[col])
                    ++flat;
                prev = map[row][col];
                if (col == n - 1)
                    ++ans;
            }
        }
    }

    static void rotate() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map[j][n - i - 1] = tmp[i][j];
            }
        }
    }
}
