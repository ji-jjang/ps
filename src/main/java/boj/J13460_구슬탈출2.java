package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J13460_구슬탈출2 {
    static char[][] board = new char[14][14];
    static int[] red = {0, 0};
    static int[] blue = {0, 0};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    c = '.';
                    red[0] = i;
                    red[1] = j;
                } else if (c == 'B') {
                    c = '.';
                    blue[0] = i;
                    blue[1] = j;
                }
                board[i][j] = c;
            }
        }
        ArrayList<Integer> seq = new ArrayList<>();
        dfs(0, seq);
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
        br.close();
    }

    static void dfs(int depth, ArrayList<Integer> seq) {
        if (depth == 10) {
            int[] r = red.clone();
            int[] b = blue.clone();
            boolean isEnd = false;
            for (int i = 0; i < seq.size(); i++) {
                int dir = seq.get(i);
                if (i != 0 && seq.get(i).equals(seq.get(i - 1)))
                    continue;
                if (isEnd || (i + 1) >= ans)
                    break;
                int ry = r[0];
                int rx = r[1];
                int by = b[0];
                int bx = b[1];
                while (board[ry + dy[dir]][rx + dx[dir]] == '.') {
                    ry += dy[dir];
                    rx += dx[dir];
                }
                while (board[by + dy[dir]][bx + dx[dir]] == '.') {
                    by += dy[dir];
                    bx += dx[dir];
                }
                if (board[ry + dy[dir]][rx + dx[dir]] == '#' && board[by + dy[dir]][bx + dx[dir]] == '#') {
                    if (ry == by && rx == bx) {
                        if (dir == 0) {
                            if (r[0] < b[0]) by++; else ry++;
                        } else if (dir == 1) {
                            if (r[1] < b[1]) rx--; else bx--;
                        } else if (dir == 2) {
                            if (r[0] < b[0]) ry--; else by--;
                        } else {
                            if (r[1] < b[1]) bx++; else rx++;
                        }
                    }
                    r[0] = ry;
                    r[1] = rx;
                    b[0] = by;
                    b[1] = bx;
                }
                if (board[by + dy[dir]][bx + dx[dir]] == 'O')
                    isEnd = true;
                if (board[ry + dy[dir]][rx + dx[dir]] == 'O') {
                    if (isEnd)
                        continue;
                    isEnd = true;
                    ans = Math.min(ans, i + 1);
                }
            }
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            seq.add(dir);
            dfs(depth + 1, seq);
            seq.remove(seq.size() - 1);
        }
    }
}
