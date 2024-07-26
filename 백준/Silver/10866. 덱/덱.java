import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				dq.offerFirst(num);
			}
			else if (cmd.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				dq.offerLast(num);
			}
			else if (cmd.equals("pop_front")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollFirst() + "\n");
				}
			}
			else if (cmd.equals("pop_back")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.pollLast() + "\n");
				}
			}
			else if (cmd.equals("size")) {
				sb.append(dq.size() + "\n");
			}
			else if (cmd.equals("empty")) {
				if (dq.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			else if (cmd.equals("front")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekFirst() + "\n");
				}
			}
			else if (cmd.equals("back")) {
				if (dq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(dq.peekLast() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
