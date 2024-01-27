package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J15685_드래곤커브 {
    static int[][] grid = new int[104][104];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> dir = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dir.add(d);
            while (g-- > 0) {
                int dirSize = dir.size();
                for (int i = dirSize - 1; i >= 0; --i)
                    dir.add((dir.get(i) + 1) % 4);
            }
            grid[y][x] = 1;
            for (int i = 0; i < dir.size(); ++i) {
                x += dx[dir.get(i)];
                y += dy[dir.get(i)];
                grid[y][x] = 1;
            }
            dir.clear();
        }
        int ans = 0;
        for (int i = 0; i < 101; ++i) {
            for (int j = 0; j < 101; ++j) {
                if (grid[i][j] == 1 && grid[i][j + 1] == 1 && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1)
                    ++ans;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
