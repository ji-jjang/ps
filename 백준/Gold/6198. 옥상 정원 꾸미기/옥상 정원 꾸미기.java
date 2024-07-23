import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		long ans = 0;
		for (int i = 0; i < n; ++i) {
			int lv = Integer.parseInt(br.readLine());
			while (!s.isEmpty() && s.peek() <= lv) {
				s.pop();
			}
			ans += s.size();
			s.push(lv);
		}
		System.out.println(ans);
		br.close();
	}
}
