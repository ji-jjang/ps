import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {

			String cmds = br.readLine();
			int size = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>(size);

			boolean isError = false;
			String line = br.readLine();
			if (size != 0) {
				String[] splited = line.substring(1, line.length() - 1).split(",");
				for (var e : splited) {
					dq.offerLast(Integer.parseInt(e));
				}
			}

			int dir = 1;
			for (var cmd : cmds.toCharArray()) {
				if ('R' == cmd) {
					dir *= -1;
				}
				if ('D' == cmd) {
					if (dq.isEmpty()) {
						isError = true;
						break;
					}
					if (dir == 1) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			if (isError) {
				sb.append("error\n");
			}
			else {
				sb.append("[");
				int n = dq.size();
				if (dir == 1) {
					for (int i = 0; i < n; ++i) {
						sb.append(dq.getFirst());
						if (i != n - 1)
							sb.append(",");
						dq.pollFirst();
					}
				} else {
					for (int i = 0; i < n; ++i) {
						sb.append(dq.getLast());
						if (i != n - 1)
							sb.append(",");
						dq.pollLast();
					}

				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}
