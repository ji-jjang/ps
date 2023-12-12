package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1654_랜선자르기 {
    static int K, N;
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        long st = 1;
        long en = Integer.MAX_VALUE;
        while (st < en) {
            long mid = (st + en + 1) / 2;
            if (solve(mid))
                st = mid;
            else
                en = mid - 1;
        }
        System.out.println(st);
    }

    private static boolean solve(long x) {
        long cur = 0;
        for (int i = 0; i < K; ++i) {
            cur += lines[i] / x;
        }
        return cur >= N;
    }
}
