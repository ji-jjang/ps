import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] pre = new int[5_004];
		int[] nxt = new int[5_004];

		for (int i = 1; i <= n; ++i) {
			pre[i] = i - 1;
			nxt[i] = i + 1;
		}
		pre[1] = n;
		nxt[n] = 1;

		int len = n;
		int cur = 0;
		int move = 1;
		nxt[0] = 1;
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		while (len > 0) {

			for (int i = 0; i < k; ++i) cur = nxt[cur];

			pre[nxt[cur]] = pre[cur];
			nxt[pre[cur]] = nxt[cur];
			sb.append(cur);
			--len;
			if (len > 0) sb.append(", ");
		}
		sb.append('>');
		System.out.println(sb.toString());
	}
}
