import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] board = new int[5][5][5];
    static int[][][] tmp = new int[5][5][5];
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; ++k)
                    board[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> seq = new ArrayList<>();
        boolean[] isSelected = new boolean[5];
        findBoard(0, seq, isSelected);
        if (ans == Integer.MAX_VALUE)
            ans = -1;
        System.out.println(ans);
        br.close();
    }

    static void findBoard(int depth, ArrayList<Integer> seq, boolean[] isSelected) {
        if (depth == 5) {
            ArrayList<Integer> rSeq = new ArrayList<>();
            findRotation(0, seq, rSeq);
            return;
        }
        for (int i = 0; i < 5; ++i) {
            if (isSelected[i]) continue;
            seq.add(i);
            isSelected[i] = true;
            findBoard(depth + 1, seq, isSelected);
            seq.remove(seq.size() - 1);
            isSelected[i] = false;
        }
    }

    static void findRotation(int depth, ArrayList<Integer> seq, ArrayList<Integer> rSeq) {
        if (depth == 5) {
            escape(seq, rSeq);
            return;
        }
        for (int dir = 0; dir < 4; ++dir) {
            rSeq.add(dir);
            findRotation(depth + 1, seq, rSeq);
            rSeq.remove(rSeq.size() - 1);
        }
    }

    static void escape(ArrayList<Integer> seq, ArrayList<Integer> rSeq) {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j)
                System.arraycopy(board[seq.get(i)][j], 0, tmp[i][j], 0, 5);
        }
        for (int i = 0; i < 5; ++i)
            rotate(i, rSeq.get(i));
        if (tmp[0][0][0] == 0 || tmp[4][4][4] == 0)
            return;
        boolean[][][] isVisited = new boolean[5][5][5];
        Queue<int[]> q = new LinkedList<>();
        isVisited[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];
            int cnt = cur[3];
            if (cnt >= ans)
                return;
            if (z == 4 && y == 4 && x == 4) {
                ans = Math.min(ans, cnt);
                return;
            }
            for (int dir = 0; dir < 6; ++dir) {
                int nz = z + dz[dir];
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5)
                    continue;
                if (isVisited[nz][ny][nx] || tmp[nz][ny][nx] == 0)
                    continue;
                isVisited[nz][ny][nx] = true;
                q.add(new int[]{nz, ny, nx, cnt + 1});
            }
        }
    }

    static void rotate(int index, Integer cnt) {
        if (cnt == 0)
            return;
        int[][] rTmp = new int[5][5];
        while (cnt-- > 0) {
            for (int j = 0; j < 5; ++j)
                System.arraycopy(tmp[index][j], 0, rTmp[j], 0, 5);
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k < 5; ++k)
                    tmp[index][k][5 - j - 1] = rTmp[j][k];
            }
        }
    }
}
