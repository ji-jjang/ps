import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) nums[i] = Integer.parseInt(st.nextToken());

		Stack<Integer> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; --i) {
			while (!s.isEmpty() && s.peek() <= nums[i]) s.pop();
			if (s.isEmpty()) ans[i] = -1;
			else ans[i] = s.peek();
			s.push(nums[i]);
		}
		for (var e : ans) sb.append(e + " ");

		System.out.println(sb.toString());
		br.close();
	}
}
