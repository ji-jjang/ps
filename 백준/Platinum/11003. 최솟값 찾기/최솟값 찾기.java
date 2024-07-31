import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			if (!dq.isEmpty() && dq.peekFirst() <= i - l) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && a[dq.peekLast()] >= a[i]) {
				dq.pollLast();
			}

			dq.offerLast(i);

			ans.append(a[dq.peekFirst()]).append(' ');
		}
		System.out.println(ans);
	}
}
