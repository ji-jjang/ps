package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int en = 0;
        int ans = Integer.MAX_VALUE;
        for (int st = 0; st < N; st++) {
            while (en < N && A[en] - A[st] < M) {
                ++en;
            }
            if (en == N)
                break ;
            ans = Math.min(ans, A[en] - A[st]);
        }
        System.out.println(ans);
    }
}
