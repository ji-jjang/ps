import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{Integer.MAX_VALUE, 0});
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());
            while (s.peek()[0] < h)
                s.pop();
            bw.write(s.peek()[1] + " ");
            s.push(new int[]{h, i});
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
