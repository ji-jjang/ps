import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0) break;

			int[] h = new int[n];
			for (int i = 0; i < n; ++i) h[i] = Integer.parseInt(st.nextToken());

			sb.append(getMax(h)).append('\n');
		}
		System.out.println(sb);
		br.close();
	}

	static long getMax(int[] h) {
		Stack<Integer> s = new Stack<>();
		long ans = 0;
		int n = h.length;

		for (int i = 0; i < n; ++i) {
			while (!s.isEmpty() && h[s.peek()] > h[i]) {
				int height = h[s.pop()];
				int width = s.isEmpty() ? i : i - s.peek() - 1;
				ans = Math.max(ans, 1L * height * width);
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			int height = h[s.pop()];
			int width = s.isEmpty() ? n : n - s.peek() - 1;
			ans = Math.max(ans, 1L * height * width);
		}

		return ans;
	}
}
