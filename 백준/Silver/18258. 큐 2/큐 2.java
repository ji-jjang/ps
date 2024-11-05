import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if ("push".equals(cmd)) {
				q.add(Integer.parseInt(st.nextToken()));
			} else if ("pop".equals(cmd)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
					continue;
				} 
				sb.append(q.poll() + "\n");
			} else if ("size".equals(cmd)) {
				sb.append(q.size() + "\n");
			} else if ("empty".equals(cmd)) {
				if (q.isEmpty()) {
					sb.append("1\n");
					continue;
				}
				sb.append("0\n");
			} else if ("front".equals(cmd)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(q.peek() + "\n");
			} else if ("back".equals(cmd)) {
				if (q.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(((LinkedList<Integer>)q).getLast() + "\n");
			}
		}
		System.out.println(sb);
	}
}
