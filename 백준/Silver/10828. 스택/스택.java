import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				s.push(x);
			} else if (cmd.equals("pop")) {
				if (s.isEmpty()) {
					sb.append("-1\n");
					continue;
				} 
				sb.append(String.valueOf(s.pop()) + '\n');
			} else if (cmd.equals("size")) {
				sb.append(String.valueOf(s.size()) + '\n');
			} else if (cmd.equals("empty")) {
				if (s.isEmpty()) {
					sb.append("1\n");
					continue;
				}
				sb.append("0\n");
			} else if (cmd.equals("top")) {
				if (s.isEmpty()) {
					sb.append("-1\n");
					continue;
				}
				sb.append(String.valueOf(String.valueOf(s.peek()) + '\n'));
			}
		}
		System.out.println(sb.toString());
	}
}
