import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int start = Integer.parseInt(st.nextToken());
            dist[start] = 0;
            q.add(start);
        }

        while (!q.isEmpty()) {
            var cur = q.poll();

            for (int k = 0; k < 31; k++) {
                int nxt;
                if ((cur & (1 << k)) != 0) {
                    nxt = cur & ~(1 << k);
                } else {
                    nxt = cur | (1 << k);
                }

                if (nxt > n || dist[nxt] >= 0) continue;

                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans);
    }
}
