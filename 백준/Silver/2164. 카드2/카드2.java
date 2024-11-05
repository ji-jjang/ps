import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; ++i)
			q.offer(i);

		while (q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.peek());
	}
}
