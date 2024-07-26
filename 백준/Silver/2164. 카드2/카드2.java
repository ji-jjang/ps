import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		Queue<Integer> q = new LinkedList<>();
		int n = sc.nextInt();
		for (int i = 1; i <= n; ++i) q.offer(i);

		while (q.size() > 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}
}
