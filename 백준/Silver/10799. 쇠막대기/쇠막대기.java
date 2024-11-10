import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		int ans = 0;
		for (int i = 0; i < line.length(); ++i) {
			if (line.charAt(i) == '(') {
				dq.offerFirst(line.charAt(i));
			}
			else {
				dq.pollFirst();
				if (line.charAt(i - 1) == ')') {
					++ans;
				}
				else 
					ans += dq.size();
			}
		}
		System.out.println(ans);
	}
}
