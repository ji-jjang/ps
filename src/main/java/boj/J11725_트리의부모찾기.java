package boj;

import java.io.*;
import java.util.ArrayList;

public class J11725_트리의부모찾기 {
    static int[] p = new int[100_001];
    static ArrayList<Integer>[] adj = new ArrayList[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 100_001; ++i) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1);
        for (int i = 2; i <= n; ++i)
            bw.write(p[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {
        for (int nxt : adj[cur]) {
            if (p[cur] == nxt) continue ;
            p[nxt] = cur;
            dfs(nxt);
        }
    }
}
