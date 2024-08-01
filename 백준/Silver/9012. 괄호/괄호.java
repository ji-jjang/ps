import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String line = br.readLine();
			if (isCorrect(line)) {
				sb.append("YES\n");
				continue;
			}
			sb.append("NO\n");
		}
		System.out.println(sb);
	}

	static boolean isCorrect(String line) {
		Map<Character, Character> m = new HashMap<>();
		Stack<Character> s = new Stack<>();
		m.put(')', '(');
		for (var c : line.toCharArray()) {
			if (c == '(') {
				s.push(c);
			} else {
				if (s.isEmpty() || s.peek() != m.get(c)) return false;
				s.pop();
			}
		}
		return s.isEmpty();
	}
}
