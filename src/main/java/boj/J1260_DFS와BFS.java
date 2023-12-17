package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J1260_DFS와BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; ++i) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            A[a].add(b);
            A[b].add(a);
        }
        for (int i = 1; i <= N; ++i)
            Collections.sort(A[i]);
        dfs(V, A, isVisited);
        System.out.println();
        Arrays.fill(isVisited, false);
        bfs(V, A, isVisited);
    }

    private static void bfs(int node, ArrayList<Integer>[] A, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        isVisited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.printf(cur + " ");
            for (int i : A[cur]) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void dfs(int v, ArrayList<Integer>[] A, boolean[] isVisited) {
        if (isVisited[v]) {
            return ;
        }
        isVisited[v] = true;
        System.out.printf("%d ", v);
        for (int i : A[v]) {
            if (!isVisited[i])
                dfs(i, A, isVisited);
        }
    }
}
