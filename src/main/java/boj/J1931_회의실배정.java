package main.java.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class J1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] numbers = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(numbers[0]);
            meetings[i][1] = Integer.parseInt(numbers[1]);
        }
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
        int end = -1;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (end <= meetings[i][0]) {
                end = meetings[i][1];
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
