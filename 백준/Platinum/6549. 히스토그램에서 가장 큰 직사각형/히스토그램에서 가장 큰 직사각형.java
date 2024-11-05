import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            Stack<int[]> s = new Stack<>(); // index, height

						long ans = 0;
						int i = 0;
						for (; i < n; ++i) {

                int h = Integer.parseInt(st.nextToken());
                int cursor = i;
                while (!s.isEmpty() && s.peek()[1] > h) {
                    var cur = s.pop();
                    int width = i - cur[0];
										int height = cur[1];
                    ans = Math.max(ans, 1L * height * width);
                    cursor = cur[0];
                }
                s.push(new int[]{cursor, h});
            }
            while (!s.isEmpty()) {
                var cur = s.pop();
                int width = i - cur[0];
								int height = cur[1];
                ans = Math.max(ans, 1L * height * width);
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
