package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J3190_뱀 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] board = new int[104][104];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y - 1][x - 1] = 2;
        }
        int l = Integer.parseInt(br.readLine());
        Queue<int[]> rot = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int dir = 1;
            if (st.nextToken().equals("L"))
                dir = -1;
            rot.add(new int[]{time, dir});
        }
        int[] head = new int[]{0, 0, 1};
        board[0][0] = 1;
        Queue<int[]> body = new LinkedList<>();
        body.add(new int[]{0, 0});
        int time = 0;
        while (true) {
            ++time;
            int y = head[0];
            int x = head[1];
            int dir = head[2];
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n)
                break;
            if (board[ny][nx] == 1)
                break;
            if (board[ny][nx] != 2) {
                var cur = body.poll();
                board[cur[0]][cur[1]] = 0;
            }
            board[ny][nx] = 1;
            body.add(new int[]{ny, nx});
            head[0] = ny;
            head[1] = nx;
            head[2] = dir;
            if (!rot.isEmpty() && time == rot.peek()[0]) {
                if (rot.peek()[1] == 1)
                    dir = (dir + 1) % 4;
                else
                    dir = (dir + 3) % 4;
                head[2] = dir;
                rot.poll();
            }
        }
        System.out.println(time);
    }
}
