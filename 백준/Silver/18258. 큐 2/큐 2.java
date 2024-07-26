import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
			}
			else if (cmd.equals("pop")) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(q.poll() + "\n");
				}
			}
			else if (cmd.equals("size")) {
				sb.append(q.size() + "\n");
			}
			else if (cmd.equals("empty")) {
					if (q.isEmpty()) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
			}
			else if (cmd.equals("front")) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(q.peek() + "\n");
				}
			}
			else if (cmd.equals("back")) {
				if (q.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(((LinkedList<Integer>)q).peekLast() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
