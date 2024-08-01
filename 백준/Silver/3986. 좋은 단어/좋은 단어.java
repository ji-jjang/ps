import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		while (n-- > 0) {
			String word = br.readLine();
			if (isGoodWords(word)) ++ans;
		}
		System.out.println(ans);
	}

	static boolean isGoodWords(String word) {
		Map<Character, Character> m = new HashMap<>();
		boolean[] isFirst = new boolean[2];
		Stack<Character> s = new Stack<>();
		m.put('A', 'A');
		m.put('B', 'B');
		for (var c : word.toCharArray()) {
			if (s.isEmpty()) {
				s.push(c);
			} else {
				if (s.peek() != m.get(c)) {
					s.push(c);
				}
				else {
					s.pop();
				}
			}
		}
		return s.isEmpty();
	}
}
