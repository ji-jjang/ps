import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] pre = new int[n];
		int[] nxt = new int[n];
		int[] dat = new int[n];
		for (int i = 0; i < n; ++i) {
			dat[i] = i + 1;
		}

		pre[0] = n - 1;
		for (int i = 0; i < n; ++i) {
			nxt[i] = i + 1;
			if (i + 1 >= n) continue;
			pre[i + 1] = i;
		}
		nxt[n - 1] = 0;

		StringBuilder sb = new StringBuilder();
		int cur = 0;
		int size = n;
		sb.append('<');
		boolean isFirst = true;
		while (size > 0) {

			int step = 0;
			if (isFirst) {
				step = 1;
				isFirst = false;
			}
			for (; step < k; ++step) {
				cur = nxt[cur];
			}
			sb.append(dat[cur]);
			nxt[pre[cur]] = nxt[cur];
			pre[nxt[cur]] = pre[cur];

			if (size != 1)
				sb.append(", ");
			--size;
		}
		sb.append('>');
		System.out.println(sb);
	}
}

