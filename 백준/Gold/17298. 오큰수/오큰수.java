import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> s = new Stack<>();
		Stack<Integer> track = new Stack<>();
		for (int i = n - 1; i >= 0; --i) {

			while (!s.isEmpty() && s.peek() <= nums[i])
				s.pop();
			if (s.isEmpty()) {
				track.push(-1);
			} else {
				track.push(s.peek());
			}
			s.push(nums[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!track.isEmpty()) {
			sb.append(track.pop() + " ");
		}
		System.out.println(sb);
	}
}
