import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = br.readLine();
			if (line.equals(".")) break;
			if (isBalanced(line.toCharArray())) sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb);
	}

	static boolean isBalanced(char[] line) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < line.length; ++i) {
			if (line[i] == '(' || line[i] == '[') {
				s.push(line[i]);
			}
			else if (line[i] == ')') {
				if (s.isEmpty() || s.peek() != '(') {
					return false;
				}
				s.pop();
			}
			else if (line[i] == ']') {
				if (s.isEmpty() || s.peek() != '[') {
					return false;
				}
				s.pop();
			}
		}
		return s.isEmpty();
	}
}
