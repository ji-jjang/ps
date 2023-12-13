package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] A = new int[N];
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(numbers[i]);
        }
        int en = 0;
        int sum = A[0];
        int ans = Integer.MAX_VALUE;
        for (int st = 0; st < N; ++st) {
            while (en < N && sum < M) {
                ++en;
                if (en != N)
                    sum += A[en];
            }
            if (en == N)
                break ;
            ans = Math.min(ans, en - st + 1);
            sum -= A[st];
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
            return ;
        }
        System.out.println(ans);
        br.close();
    }
}
