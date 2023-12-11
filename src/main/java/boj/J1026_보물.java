package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += ((long) A[i] * B[N - 1 - i]);
        }
        System.out.println(ans);
    }
}
