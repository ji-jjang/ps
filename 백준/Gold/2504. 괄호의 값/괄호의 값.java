import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] line = br.readLine().toCharArray();
		Deque<Character> dq = new ArrayDeque<>();

		int ans = 0;
		boolean isCorrect = true;
		int mult = 1;
		for (int i = 0; i < line.length; ++i) {
			if (line[i] == '(') {
				dq.offerFirst(line[i]);
				mult *= 2;
			}
			else if (line[i] == '[') {
				dq.offerFirst(line[i]);
				mult *= 3;
			}
			else if (line[i] == ')') {
				if (dq.isEmpty() || dq.peekFirst() != '(') {
					isCorrect = false;
					break;
				}
				dq.pollFirst();
				if (line[i - 1] == '(')
					ans += mult;
				mult /= 2;
			}
			else if (line[i] == ']') {
				if (dq.isEmpty() || dq.peekFirst() != '[') {
					isCorrect = false;
					break;
				}
				dq.pollFirst();
				if (line[i - 1] == '[')
					ans += mult;
				mult /= 3;
			}
		}
		if (!dq.isEmpty()) isCorrect = false;
		if (!isCorrect)
			ans = 0;
		System.out.println(ans);
	}
}
