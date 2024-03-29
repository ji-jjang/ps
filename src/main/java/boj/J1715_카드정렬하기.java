package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class J1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            ans += a + b;
            pq.add(a + b);
        }
        System.out.println(ans);
    }
}
