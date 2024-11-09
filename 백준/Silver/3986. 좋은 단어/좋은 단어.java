import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		while (n-- > 0) {
			String line = br.readLine();
			Deque<Character> dq = new ArrayDeque<>();
			for (var c : line.toCharArray()) {
				if (dq.isEmpty()) {
					dq.push(c);
				}
				else {
					if (dq.peekFirst() != c)
						dq.offerFirst(c);
					else
						dq.pollFirst();
				}
			}
			if (dq.isEmpty()) ++ans;
		}
		System.out.println(ans);
	}
}
