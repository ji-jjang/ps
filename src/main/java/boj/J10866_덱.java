package boj;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class J10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("push_front".equals(cmd)) {
                int num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            } else if ("push_back".equals(cmd)) {
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            } else if ("pop_front".equals(cmd)) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.pollFirst() + "\n");
                }
            } else if ("pop_back".equals(cmd)) {
                if (dq.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(dq.pollLast() + "\n");
                }
            } else if ("size".equals(cmd)) {
                bw.write(dq.size() + "\n");
            } else if ("empty".equals(cmd)) {
                if (dq.isEmpty())
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            } else if ("front".equals(cmd)) {
                if (dq.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(dq.getFirst() + "\n");
            } else {
                if (dq.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(dq.getLast() + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
