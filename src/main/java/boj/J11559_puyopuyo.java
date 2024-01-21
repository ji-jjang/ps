package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J11559_puyopuyo {
    static char[][] board = new char[14][14];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static boolean[][] isVisited = new boolean[14][14];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 6; j++)
                board[i][j] = line.charAt(j);
        }
        int ans = 0;
        while (true) {
            for (int i = 0; i < 12; ++i) {
                for (int j = 0; j < 6; ++j)
                    isVisited[i][j] = false;
            }
            if (!bomb())
                break;
            for (int col = 0; col < 6; ++col) {
                for (int row = 11; row >= 0; --row)
                    if (board[row][col] != '.')
                        drop(row, col);
            }
            ++ans;
        }
        System.out.println(ans);
        sc.close();
    }

    static boolean bomb() {
        boolean isBoomed = false;
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 6; ++j) {
                if (board[i][j] != '.') {
                    if (erase(i, j, board[i][j]))
                        isBoomed = true;
                }
            }
        }
        return isBoomed;
    }

    static boolean erase(int y, int x, char c) {
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> path = new LinkedList<>();
        isVisited[y][x] = true;
        q.add(new int[]{y, x});
        boolean canErase = false;
        while (!q.isEmpty()) {
            var cur = q.poll();
            path.add(cur);
            for (int dir = 0; dir < 4; ++dir) {
                int ny = cur[0] + dy[dir];
                int nx = cur[1] + dx[dir];
                if (ny < 0 || ny >= 12 || nx < 0 || nx >= 6)
                    continue;
                if (board[ny][nx] != c || isVisited[ny][nx])
                    continue;
                isVisited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
        if (path.size() >= 4)
            canErase = true;

        while (!path.isEmpty()) {
            var cur = path.poll();
            if (canErase)
                board[cur[0]][cur[1]] = '.';
        }
        return canErase;
    }

    static void drop(int row, int col) {
        if (row >= 12 || board[row + 1][col] != '.')
            return;
        board[row + 1][col] = board[row][col];
        board[row][col] = '.';
        drop(row + 1, col);
    }
}
