package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J14499_주사위굴리기 {
    static int n, m, y, x, k;
    static int[][] dice = new int[4][3];
    static int[][] tmp = new int[4][3];
    static int[][] map = new int[24][24];
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dx = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> path = new ArrayList<>();
        while (k-- > 0) {
            int dir = Integer.parseInt(st.nextToken());
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m)
                continue;
            y = ny;
            x = nx;
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 3; ++j)
                    tmp[i][j] = dice[i][j];
            }
            if (dir == 1)
                rollRight();
            else if (dir == 2)
                rollLeft();
            else if (dir == 3)
                rollUp();
            else
                rollDown();
            if (map[y][x] == 0)
                map[y][x] = dice[3][1];
            else {
                dice[3][1] = map[y][x];
                map[y][x] = 0;
            }
            path.add(dice[1][1]);
        }
        for (var e : path)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static void rollRight() {
        dice[1][0] = tmp[3][1];
        dice[1][1] = tmp[1][0];
        dice[1][2] = tmp[1][1];
        dice[3][1] = tmp[1][2];
    };

    static void rollLeft() {
        dice[1][0] = tmp[1][1];
        dice[1][1] = tmp[1][2];
        dice[1][2] = tmp[3][1];
        dice[3][1] = tmp[1][0];
    };

    static void rollUp() {
        dice[0][1] = tmp[1][1];
        dice[1][1] = tmp[2][1];
        dice[2][1] = tmp[3][1];
        dice[3][1] = tmp[0][1];
    };

    static void rollDown() {
        dice[0][1] = tmp[3][1];
        dice[1][1] = tmp[0][1];
        dice[2][1] = tmp[1][1];
        dice[3][1] = tmp[2][1];
    }
}
