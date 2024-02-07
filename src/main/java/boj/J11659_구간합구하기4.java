package main.java.boj;

import java.io.*;
import java.util.StringTokenizer;

public class J11659_구간합구하기4 {
    static int[] dp = new int[100_004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + num;
        }
        for (int i = 0; i < M; i++) {
            int start, end;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            bw.write(dp[end] - dp[start - 1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
