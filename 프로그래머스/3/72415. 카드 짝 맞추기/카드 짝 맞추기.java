import java.util.*;

class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] board, int r, int c) {
        List<int[]> cards = new ArrayList<>();
        Map<Integer, List<int[]>> cardPos = new HashMap<>();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] > 0) {
                    cardPos.putIfAbsent(board[i][j], new ArrayList<>());
                    cardPos.get(board[i][j]).add(new int[]{i, j});
                }
            }
        }
        
        for (var pos : cardPos.values()) {
            cards.add(pos.get(0));
            cards.add(pos.get(1));
        }
        
        List<List<int[]>> perms = new ArrayList<>();
        boolean[] visited = new boolean[cards.size()];
        dfs(new ArrayList<>(), cards, visited, perms);
        
        int ans = Integer.MAX_VALUE;

        for (var perm : perms) {
            ans = Math.min(ans, getMinimumMove(board, r, c, perm));
        }
        
        return ans;
    }
    
   void dfs(List<int[]> cur, List<int[]> cards, boolean[] isVisited, List<List<int[]>> perms) {
        if (cur.size() == cards.size()) {
            perms.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < cards.size(); i += 2) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                cur.add(cards.get(i));
                cur.add(cards.get(i + 1));
                dfs(cur, cards, isVisited, perms);
                cur.remove(cur.size() - 1);
                cur.remove(cur.size() - 1);
                
                cur.add(cards.get(i + 1));
                cur.add(cards.get(i));
                dfs(cur, cards, isVisited, perms);
                cur.remove(cur.size() - 1);
                cur.remove(cur.size() - 1);
                
                isVisited[i] = false;
            }
        }
    }
    
    int getMinimumMove(int[][] board, int r, int c, List<int[]> perm) {
        int[][] tmp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(board[i], 0, tmp[i], 0, 4);
        }
        
        int move = 0;
        int cr = r;
        int cc = c;
        
        for (int i = 0; i < perm.size(); i += 2) {
            int[] firstCard = perm.get(i);
            int[] secondCard = perm.get(i + 1);
            
            int firstMove = bfs(tmp, cr, cc, firstCard[0], firstCard[1]);
            int secondMove = bfs(tmp, firstCard[0], firstCard[1], secondCard[0], secondCard[1]);
            
            move += firstMove + secondMove + 2; 
            tmp[firstCard[0]][firstCard[1]] = 0;
            tmp[secondCard[0]][secondCard[1]] = 0;
            
            cr = secondCard[0];
            cc = secondCard[1];
        }
        
        return move;
    }
    
    int bfs(int[][] board, int sy, int sx, int ey, int ex) {
        if (sy == ey && sx == ex) {
            return 0;
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[4][4];
        q.add(new int[]{sy, sx, 0});
        isVisited[sy][sx] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (!isOOB(ny, nx) && !isVisited[ny][nx]) {
                    if (ny == ey && nx == ex) {
                        return cnt + 1;
                    }
                    isVisited[ny][nx] = true;
                    q.add(new int[]{ny, nx, cnt + 1});                 
                }
                
                ny = y;
                nx = x;
                while (!isOOB(ny + dy[i], nx + dx[i])) {
                    ny += dy[i];
                    nx += dx[i];
                    if (board[ny][nx] != 0) {
                        break;
                    }
                }
                if (!isVisited[ny][nx]) {
                    if (ny == ey && nx == ex) {
                        return cnt + 1;
                    }
                    isVisited[ny][nx] = true;
                    q.add(new int[]{ny, nx, cnt + 1});
                }
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    boolean isOOB(int r, int c) {
        return r < 0 || r >= 4 || c < 0 || c >= 4;
    }
}