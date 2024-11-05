import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();

		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();

			if (("push_front").equals(cmd)) {
				dq.offerFirst(Integer.parseInt(st.nextToken()));
			} else if (("push_back").equals(cmd)) {
				dq.offerLast(Integer.parseInt(st.nextToken()));
			} else if (("pop_front").equals(cmd)) {

				if (dq.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(dq.pollFirst() + "\n");

			} else if (("pop_back").equals(cmd)) {

				if (dq.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(dq.pollLast() + "\n");

			} else if (("size").equals(cmd)) {

				sb.append(dq.size() + "\n");

			} else if (("empty").equals(cmd)) {
				
				if (dq.isEmpty()) {
					sb.append("1\n");
					continue;
				}
				sb.append("0\n");

			} else if (("front").equals(cmd)) {

				if (dq.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(dq.getFirst() + "\n");

			} else if (("back").equals(cmd)) {

				if (dq.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(dq.getLast() + "\n");
			}
		}
		System.out.println(sb);
	}
}
