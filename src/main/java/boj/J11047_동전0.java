package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J11047_동전0 {
    private static int[] c = new int[14];
    private static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++)
            c[i] = Integer.parseInt(br.readLine());
        for (int i = n - 1; i >= 0; --i) {
            ans += k / c[i];
            k %= c[i];
        }
        System.out.println(ans);
        br.close();
    }
}
