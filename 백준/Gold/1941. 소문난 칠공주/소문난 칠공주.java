import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static char[][] seats = new char[5][5];
    static boolean[][] isSelected = new boolean[5][5];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; ++i) {
            String line = br.readLine();
            for (int j = 0; j < 5; ++j) {
                seats[i][j] = line.charAt(j);
            }
        }

        List<int[]> pos = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                pos.add(new int[]{i, j});
            }
        }

        dfs(pos, new ArrayList<>(), 0, 0);

        System.out.println(ans);
    }

    public static void dfs(List<int[]> pos, List<int[]> sseats, int idx, int daCnt) {

        if (sseats.size() == 7) {
            if (daCnt >= 4) {
                if (isAdjacent(sseats)) {
                    ++ans;
                }
            }
            return;
        }

        if (idx >= pos.size()) {
            return;
        }

        int[] cur = pos.get(idx);
        int y = cur[0];
        int x = cur[1];
        char student = seats[y][x];

        sseats.add(cur);
        dfs(pos, sseats, idx + 1, daCnt + (student == 'S' ? 1 : 0));
        sseats.remove(sseats.size() - 1);

        dfs(pos, sseats, idx + 1, daCnt);
    }

    public static boolean isAdjacent(List<int[]> sseats) {
        boolean[][] isVisited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;

        int y = sseats.get(0)[0];
        int x = sseats.get(0)[1];

        q.offer(new int[]{y, x});
        isVisited[y][x] = true;

        Set<String> selectedSet = new HashSet<>();
        for (int[] pos : sseats) {
            selectedSet.add(pos[0] + "," + pos[1]);
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            y = cur[0];
            x = cur[1];

            for (int dir = 0; dir < 4; ++dir) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                    if (!isVisited[ny][nx] && selectedSet.contains(ny + "," + nx)) {
                        isVisited[ny][nx] = true;
                        q.offer(new int[]{ny, nx});
                        ++cnt;
                    }
                }
            }
        }

        return cnt == 7;
    }
}

