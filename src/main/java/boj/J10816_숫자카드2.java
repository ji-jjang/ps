package main.java.boj;

import java.io.*;
import java.util.Arrays;

public class J10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] sang = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(sang[i]);
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(targets[i]);
            bw.write((upperBound(A, N, target) - lowerBound(A, N, target)) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int lowerBound(int[] A, int N, int target) {
        int st = 0;
        int en = N;

        while (st < en) {
            int mid = (st + en) / 2;
            if (A[mid] < target) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        return st;
    }


    private static int upperBound(int[] A, int N, int target) {
        int st = 0;
        int en = N;

        while (st < en) {
            int mid = (st + en) / 2;
            if (A[mid] <= target) {
                st = mid + 1;
            } else {
                en = mid;
            }
        }
        return st;
    }
}
