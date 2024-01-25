package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J14502_연구소 {
    static int n, m;
    static int[][] map = new int[10][10];
    static ArrayList<int[]> emp = new ArrayList<>();
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    emp.add(new int[]{i, j});
                else if (map[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }
        boolean[] isSelected = new boolean[emp.size()];
        dfs(0, new ArrayList<>(), isSelected);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int depth, ArrayList<int[]> seq, boolean[] isSelected) {
        if (depth == 3) {
            bfs(seq);
            return;
        }
        for (int i = 0; i < emp.size(); i++) {
            if (isSelected[i])
                continue;
            isSelected[i] = true;
            seq.add(emp.get(i));
            dfs(depth + 1, seq, isSelected);
            seq.remove(seq.size() - 1);
            isSelected[i] = false;
        }
    }

    static void bfs(ArrayList<int[]> seq) {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++)
            System.arraycopy(map[i], 0, tmp[i], 0, m);
        for (var e : seq)
            tmp[e[0]][e[1]] = 1;
        Queue<int[]> q = new LinkedList<>();
        for (var e : virus)
            q.add(e);
        while (!q.isEmpty()) {
            var cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                    continue;
                if (tmp[ny][nx] != 0)
                    continue;
                tmp[ny][nx] = 2;
                q.add(new int[]{ny, nx});
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0)
                    cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}