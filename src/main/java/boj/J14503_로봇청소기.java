package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J14503_로봇청소기 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] room = new int[54][54];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                room[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, dir});
        while (!q.isEmpty()) {
            var cur = q.poll();
            y = cur[0];
            x = cur[1];
            dir = cur[2];
            if (room[y][x] == 0) {
                ++ans;
                room[y][x] = 2;
            }
            boolean isDirty = false;
            for (int direct = 0; direct < 4; direct++) {
                int ny = y + dy[direct];
                int nx = x + dx[direct];
                if (room[ny][nx] == 0) {
                    isDirty = true;
                    break;
                }
            }
            if (!isDirty) {
                int ny = y - dy[dir];
                int nx = x - dx[dir];
                if (room[ny][nx] == 1)
                    continue;
                q.add(new int[]{ny, nx, dir});
            } else {
                dir = (dir + 3) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (room[ny][nx] == 0)
                    q.add(new int[]{ny, nx, dir});
                else
                    q.add(new int[]{y, x, dir});
            }
        }
        System.out.println(ans);
        br.close();
    }
}
