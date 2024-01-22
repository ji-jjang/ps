package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J13335_트럭 {
    static int[] bridge = new int[1004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            q.add(weight);
        }
        int time = 0;
        while (!q.isEmpty()) {
            for (int i = w; i >= 1; --i)
                bridge[i] = bridge[i - 1];
            bridge[0] = 0;
            int curWeight = 0;
            for (int i = 0; i < w; i++)
                curWeight += bridge[i];
            ++time;
            if (curWeight + q.peek() <= l) {
                bridge[0] = q.peek();
                curWeight -= q.poll();
            }
        }
        System.out.println(time + w);
    }
}
