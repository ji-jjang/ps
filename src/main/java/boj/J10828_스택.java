package boj;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class J10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("push".equals(cmd)) {
                int x = Integer.parseInt(st.nextToken());
                s.push(x);
            } else if ("pop".equals(cmd)) {
                if (s.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(s.pop() + "\n");
            } else if ("size".equals(cmd)) {
                bw.write(s.size() + "\n");
            } else if ("empty".equals(cmd)) {
                if (s.isEmpty()) {
                    bw.write(1 + "\n");
                    continue;
                }
                bw.write(0 + "\n");
            } else if ("top".equals(cmd)) {
                if (s.isEmpty()) {
                    bw.write(-1 + "\n");
                    continue;
                }
                bw.write(s.peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
