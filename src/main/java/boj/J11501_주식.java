package boj;

import java.io.*;
import java.util.StringTokenizer;

public class J11501_주식 {
    static int[] prices = new int[1_000_004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long ans = 0;
            for (int i = 0; i < n; i++)
                prices[i] = Integer.parseInt(st.nextToken());
            int mx = prices[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                int now = prices[i];
                if (mx < now)
                    mx = now;
                ans += mx - now;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
