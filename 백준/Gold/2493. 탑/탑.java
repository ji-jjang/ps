import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<int[]> s = new Stack<>(); // num, index

		boolean isFirst = true;
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			if (isFirst) {
				sb.append("0" + " ");
				isFirst = false;
				s.push(new int[]{num, i + 1});
				continue;
			}
			while (!s.isEmpty() && s.peek()[0] < num) {
				s.pop();
			}
			if (s.isEmpty()) {
				sb.append("0" + " ");
			} else {
				sb.append(s.peek()[1] + " ");
			}
			s.push(new int[]{num, i + 1});
		}
		System.out.println(sb);
	}
}
