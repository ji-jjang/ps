import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if ("push".equals(op)) {
                int num = Integer.parseInt(st.nextToken());
                Q.add(num);
            } else if ("pop".equals(op)) {
                if (Q.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(Q.poll() + "\n");
                }
            } else if ("size".equals(op)) {
                bw.write(Q.size() + "\n");
            } else if ("empty".equals(op)) {
                if (Q.isEmpty())
                    bw.write(1 + "\n");
                else
                    bw.write(0 + "\n");
            } else if ("front".equals(op)) {
                if (Q.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(Q.peek() + "\n");
            } else if ("back".equals(op)) {
                if (Q.isEmpty())
                    bw.write(-1 + "\n");
                else
                    bw.write(((LinkedList<Integer> )Q).getLast() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
