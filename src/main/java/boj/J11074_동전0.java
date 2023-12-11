package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J11074_동전0 {
    static int[] coins = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int N = Integer.parseInt(numbers[0]);
        int K = Integer.parseInt(numbers[1]);
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N - 1; i >= 0; --i) {
            ans += (K / coins[i]);
            K %= coins[i];
        }
        System.out.println(ans);
    }
}
