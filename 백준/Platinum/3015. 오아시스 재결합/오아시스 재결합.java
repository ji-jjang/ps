import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(br.readLine());

		Stack<int[]> s = new Stack<>();

		long ans = 0;
		for (int i = 0; i < n; ++i) {
				int cnt = 1;
				while (!s.isEmpty() && s.peek()[0] <= arr[i]) {
						int[] top = s.pop();
						ans += top[1];
						if (top[0] == arr[i]) {
								cnt += top[1];
						}
				}
				if (!s.isEmpty()) {
						ans++;
				}
				s.push(new int[]{arr[i], cnt});
		}

		System.out.println(ans);
        
		br.close();
	}
}
