import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>(); // h, cnt
																		//
		long ans = 0;
		while (n-- > 0) {
			int h = Integer.parseInt(br.readLine());
			int cnt = 1;
			while (!s.isEmpty() && s.peek()[0] <= h) {

				ans += s.peek()[1];
				if (s.peek()[0] == h) {
					cnt += s.pop()[1];
				}
				else
					s.pop();
			}
			if (!s.isEmpty()) {
				++ans;
			}
			s.push(new int[]{h, cnt});
		}
		System.out.println(ans);
	}
}
