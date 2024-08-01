import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Character> m = new HashMap<>();
		Stack<Character> s = new Stack<>();
		m.put(')', '(');

		int ans = 0;
		String line = br.readLine();
		for (int i = 0; i < line.length(); ++i) {
			if (line.charAt(i) == '(')
				s.push(line.charAt(i));
			else {
				if (line.charAt(i - 1) != line.charAt(i)) {
					ans += s.size() - 1;
				} else {
					++ans;
				}
				s.pop();
			}
		}
		System.out.println(ans);
	}
}
