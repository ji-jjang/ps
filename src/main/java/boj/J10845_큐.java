package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("push".equals(cmd)) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            } else if ("pop".equals(cmd)) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(q.poll() + "\n");
            } else if ("size".equals(cmd)) {
                bw.write(q.size() + "\n");
            } else if ("empty".equals(cmd)) {
                if (q.isEmpty()) {
                    bw.write(1 + "\n");
                    continue;
                }
                bw.write(0 + "\n");
            } else if ("front".equals(cmd)) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(q.peek() + "\n");
            } else if ("back".equals(cmd)) {
                if (q.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(((LinkedList<Integer>)q).getLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
