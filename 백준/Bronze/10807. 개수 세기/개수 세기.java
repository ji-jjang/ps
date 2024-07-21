import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(br.readLine());

		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			int num = Integer.parseInt(st.nextToken());
			m.put(num, m.getOrDefault(num, 0) + 1);
		}
		System.out.println(m.getOrDefault(target, 0));
		br.close();
	}
}
