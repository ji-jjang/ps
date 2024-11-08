import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		Deque<int[]> dq = new LinkedList<>(); // index, number
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());

			if (!dq.isEmpty() && dq.peekFirst()[0] + l <= i) {
				dq.pollFirst();
			}

			while (!dq.isEmpty() && dq.peekLast()[1] > num) {
				dq.pollLast();
			}

			dq.offerLast(new int[]{i, num});
			sb.append(dq.peekFirst()[1] + " ");
		}
		System.out.println(sb);
	}
}
