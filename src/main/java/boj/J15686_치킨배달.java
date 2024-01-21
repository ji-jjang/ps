package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class J15686_치킨배달 {
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chick = new ArrayList<>();
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    house.add(new int[]{i, j});
                else if (num == 2)
                    chick.add(new int[]{i, j});
            }
        }
        boolean[] isVisited = new boolean[chick.size()];
        dfs(0, 0, new ArrayList<>(), isVisited);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int depth, int start, ArrayList<int[]> seq, boolean[] isVisited) {
        if (depth == m) {
            int sum = 0;
            for (var h : house) {
                int minChickDist = Integer.MAX_VALUE;
                for (var c : seq)
                    minChickDist = Math.min(minChickDist, Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]));
                sum += minChickDist;
            }
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = start; i < chick.size(); ++i) {
            if (isVisited[i])
                continue;
            isVisited[i] = true;
            seq.add(chick.get(i));
            dfs(depth + 1, i + 1, seq, isVisited);
            isVisited[i] = false;
            seq.remove(seq.size() - 1);
        }
    }
}
