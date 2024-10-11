import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] room = new int[14][14];
    static int[][] cRoom = new int[14][14];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    static ArrayList<int[]> cctv = new ArrayList<>();
    static int[][][] cctvDir = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] >= 1 && room[i][j] <= 5)
                    cctv.add(new int[]{i, j});
            }
        }
        List<List<Integer>> seq = new ArrayList<>();
        dfs(0, seq);
        System.out.println(ans);
    }

    static void dfs(int depth, List<List<Integer>> seq) {
        if (depth == cctv.size()) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    cRoom[i][j] = room[i][j];
                }
            }
            for (int i = 0; i < seq.size(); ++i) {
                for (var dir : seq.get(i)) {
                    watchArea(cctv.get(i)[0], cctv.get(i)[1], dir);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (cRoom[i][j] == 0)
                        ++cnt;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }
        int type = room[cctv.get(depth)[0]][cctv.get(depth)[1]];
        for (var dir : cctvDir[type]) {
            List<Integer> dirs = new ArrayList<>();
            for (var e : dir)
                dirs.add(e);
            seq.add(dirs);
            dfs(depth + 1, seq);
            seq.remove(seq.size() - 1);
        }
    }

    static void watchArea(int y, int x, Integer dir) {
        while (true) {
            y += dy[dir];
            x += dx[dir];
            if (y < 0 || x < 0 || y >= n || x >= m)
                break;
            if (cRoom[y][x] == 6)
                break;
            if (cRoom[y][x] >= 1 && cRoom[y][x] <= 5)
                continue;
            cRoom[y][x] = 9;
        }
    }
}
