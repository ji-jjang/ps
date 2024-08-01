import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Character> m = new HashMap<>();
		Stack<Character> s = new Stack<>();
		m.put(')', '(');
		m.put(']', '[');

		int mult = 1;
		int ans = 0;
		String line = br.readLine();
		boolean isCorrect = true;
		for (int i = 0; i < line.length(); ++i) {
			char c = line.charAt(i);
			if (c == '(') {
				mult *= 2;
				s.push(c);
			}
			else if (c == '[') {
				mult *= 3;
				s.push(c);
			}
			else if (c == ')') {
				if (s.isEmpty() || s.peek() != m.get(c)) {
					isCorrect = false;
					break;
				}
				if (line.charAt(i - 1) == '(')
					ans += mult;
				mult /= 2;
				s.pop();
			}
			else if (c == ']') {
				if (s.isEmpty() || s.peek() != m.get(c)) {
					isCorrect = false;
					break;
				}
				if (line.charAt(i - 1) == '[')
					ans += mult;
				mult /= 3;
				s.pop();
			}
		}
		if (!s.isEmpty()) isCorrect = false;
		if (!isCorrect) ans = 0;
		System.out.println(ans);
	}
}
