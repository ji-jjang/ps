package boj;

import java.io.*;
import java.util.PriorityQueue;

public class J11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA != absB)
                return absA - absB;
            return a - b;
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty())
                    bw.write("0\n");
                else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(num);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
