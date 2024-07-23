import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();

		s.push(1);
		int n = Integer.parseInt(br.readLine());
		int st = 0;
		boolean isPassed = true;
		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			for (int i = st + 1; i <= num; ++i) {
				s.push(i);
				sb.append("+\n");
			}
			if (s.peek() == num) {
				int tmp = s.pop();
				sb.append("-\n");
				if (tmp >= st)
					st = tmp;
			} else {
				isPassed = false;
			}
		}
		String ans = isPassed ? sb.toString() : "NO";
		System.out.println(ans);
	}
}
