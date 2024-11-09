import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String line = br.readLine();
			if (".".equals(line)) break;

			Deque<Character> dq = new ArrayDeque<>();

			boolean isBalanced = true;
			for (var c : line.toCharArray()) {
				if (c == '(' || c == '[') {
					dq.offerFirst(c);
				}
				else if (c == ')') {
					if (dq.isEmpty() || dq.peekFirst() != '(') {
						isBalanced = false;
						break;
					}
					dq.pollFirst();
				}
				else if (c == ']') {
					if (dq.isEmpty() || dq.peekFirst() != '[') {
						isBalanced = false;
						break;
					}
					dq.pollFirst();
				}
			}
			if (!dq.isEmpty()) isBalanced = false;
			if (isBalanced) {
				sb.append("yes\n");
				continue;
			}
			sb.append("no\n");
		}
		System.out.println(sb);
	}
}
