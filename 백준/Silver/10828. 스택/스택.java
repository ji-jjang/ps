import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();

			if ("push".equals(cmd)) {

				s.push(Integer.parseInt(st.nextToken()));

			} else if ("pop".equals(cmd)) {

				if (s.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(s.pop() + "\n");

			} else if ("size".equals(cmd)) {

				sb.append(s.size() + "\n");

			} else if ("empty".equals(cmd)) {

				if (s.isEmpty()) {
					sb.append("1\n");
					continue;
				}
				sb.append("0\n");

			} else {

				if (s.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(s.peek() + "\n");
			}
		}
		System.out.println(sb);
	}
}
