import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int ret = 0;
		Stack<Integer> s = new Stack<>();

		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());

			ret += num;
			if (num == 0 && !s.isEmpty()) {
				ret -= s.pop();
				continue;
			}
			s.push(num);
		}
		System.out.println(ret);
	}
}
