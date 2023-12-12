package main.java.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class J18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        ArrayList<Integer> C = new ArrayList<>(N);
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(numbers[i]);
            B[i] = Integer.parseInt(numbers[i]);
        }
        Arrays.sort(B);
        for (int i = 0; i < N; ++i) {
            if (i == 0 || B[i] != B[i - 1])
                C.add(B[i]);
        }
        for (int i = 0; i < N; ++i) {
            bw.write(upperBound(C, A[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int upperBound(ArrayList<Integer> A, int target) {
        int st = 0;
        int en = A.size();

        while (st < en) {
           int mid = (st + en) / 2;
           if (A.get(mid) <= target)
               st = mid + 1;
           else
               en = mid;
        }
        return st - 1;
    }
}
