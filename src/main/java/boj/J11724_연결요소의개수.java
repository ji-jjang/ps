package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J11724_연결요소의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int ans = 0;
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        boolean[] isVisited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            A[a].add(b);
            A[b].add(a);
        }
        for (int i = 1; i <= N; ++i) {
            if (!isVisited[i]) {
                ++ans;
                dfs(i, A, isVisited);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i, ArrayList<Integer>[] A, boolean[] isVisited) {
        if (isVisited[i])
            return ;
        isVisited[i] = true;
        for (int a : A[i]) {
            if (!isVisited[a]) {
                dfs(a, A, isVisited);
            }
        }
    }
}
