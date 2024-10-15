import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] paper = new int[504][504];
    static int ans = 0;
    static int[][][] shape = {
            {{1, 1, 1, 1}},
            {{1}, {1}, {1}, {1}},
            {{1, 1}, {1, 1}},
            {{1, 0}, {1, 0}, {1, 1}},
            {{0, 1}, {0, 1}, {1, 1}},
            {{1, 1, 1}, {1, 0, 0}},
            {{1, 1, 1}, {0, 0, 1}},
            {{1, 1}, {0, 1}, {0, 1}},
            {{1, 1}, {1, 0}, {1, 0}},
            {{0, 0, 1}, {1, 1, 1}},
            {{1, 0, 0}, {1, 1, 1}},
            {{1, 0}, {1, 1}, {0, 1}},
            {{0, 1}, {1, 1}, {1, 0}},
            {{0, 1, 1}, {1, 1, 0}},
            {{1, 1, 0}, {0, 1, 1}},
            {{1, 1, 1}, {0, 1, 0}},
            {{0, 1}, {1, 1}, {0, 1}},
            {{1, 0}, {1, 1}, {1, 0}},
            {{0, 1, 0}, {1, 1, 1}}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < shape.length; k++) {
                    checkScore(k, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    static void checkScore(int index, int y, int x) {
        int r = shape[index].length;
        int c = shape[index][0].length;
        if (y + r > n || x + c > m)
            return;
        int score = 0;
        for (int i = y; i < y + r; ++i) {
            for (int j = x; j < x + c; ++j) {
                if (shape[index][i - y][j - x] == 1)
                    score += paper[i][j];
            }
        }
        ans = Math.max(ans, score);
    }
}
