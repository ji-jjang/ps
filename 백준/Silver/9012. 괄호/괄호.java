import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			String line = br.readLine();
			Deque<Character> dq = new ArrayDeque<>();
			boolean isCorrect = true;
			for (var c : line.toCharArray()) {
				if (c == '(') {
					dq.offerFirst(c);
				} else {
					if (dq.isEmpty() || dq.peekFirst() != '(') {
						isCorrect = false; 
						break;
					}
					dq.pollFirst();
				}
			}
			if (!dq.isEmpty()) isCorrect = false;
			sb.append(isCorrect ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}
