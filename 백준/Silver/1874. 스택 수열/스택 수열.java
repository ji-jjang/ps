import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();

		boolean isError = false;
		int cursor = 0;
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			for (int i = cursor + 1; i <= num; ++i) {
				sb.append("+\n");
				s.push(i);
			}
			cursor = Math.max(cursor, num);
			if (s.isEmpty() || s.peek() < num) {
				isError = true;
				break;
			}

			while (true) {
				if (s.peek() == num) {
					s.pop();
					sb.append("-\n");
					break;
				}
				s.pop();
				sb.append("-\n");
			}
		}
		if (isError) {
			System.out.println("NO");
			return;
		}
		System.out.println(sb);
	}
}
