import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();

		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; ++i) list.add(i);
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < m; ++i) {
			int num = Integer.parseInt(st.nextToken());

			int left = list.indexOf(num);
			int right = list.size() - left;
			ans += Math.min(left, right);

			if (left <= right) {
				for (int j = 0; j < left; ++j) list.addLast(list.removeFirst());
			}
			else {
				for (int j = 0; j < right; ++j) list.addFirst(list.removeLast());
			}
			list.removeFirst();
		}
		System.out.println(ans);
	}
}
