import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> dq = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; ++i)
			dq.offerLast(i);

		int t = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		while (t-- > 0) {
			int target = Integer.parseInt(st.nextToken());

			int index = ((LinkedList<Integer>) dq).indexOf(target);
			int moveCnt = Math.min(index, dq.size() - index);
			boolean rotateLeft = (moveCnt == index);

			ans += moveCnt;
			while (moveCnt-- > 0) {
				if (rotateLeft) {
					dq.offerLast(dq.pollFirst());
				} else {
					dq.offerFirst(dq.pollLast());
				}
			}
			dq.pollFirst();
		}
		System.out.println(ans);
	}
}
