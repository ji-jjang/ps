import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, h;
    static int[][] lad = new int[34][14];
    static ArrayList<int[]> emp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lad[a][b] = 1;
            lad[a][b + 1] = 2;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; ++j) {
                if (lad[i][j] == 0 && lad[i][j + 1] == 0)
                    emp.add(new int[]{i, j});
            }
        }
        int ans = -1;
        for (int i = 0; i <= 3; i++) {
            ans = dfs(0, i, 0);
            if (ans != -1)
                break;
        }
        System.out.println(ans);
    }

    static int dfs(int depth, int mx, int start) {
        if (depth == mx) {
            if (isStraight())
                return depth;
            return -1;
        }
        for (int i = start; i < emp.size(); ++i) {
            int[] cur = emp.get(i);
            if (lad[cur[0]][cur[1]] != 0 || lad[cur[0]][cur[1] + 1] != 0)
                continue;
            lad[cur[0]][cur[1]] = 1;
            lad[cur[0]][cur[1] + 1] = 2;
            if (dfs(depth + 1, mx, i + 1) > 0)
                return mx;
            lad[cur[0]][cur[1]] = 0;
            lad[cur[0]][cur[1] + 1] = 0;
        }
        return -1;
    }

    static boolean isStraight() {
        for (int col = 1; col <= n; ++col) {
            int sCol = col;
            int row = 0;
            while (row <= h) {
                if (lad[row][col] == 1)
                    ++col;
                else if (lad[row][col] == 2)
                    --col;
                ++row;
            }
            if (sCol != col)
                return false;
        }
        return true;
    }
}
