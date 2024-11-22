import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");
		long a = Integer.parseInt(tokens[0]);
		long b = Integer.parseInt(tokens[1]);
		long c = Integer.parseInt(tokens[2]);

		System.out.println(recur(a, b, c));
	}

	static long recur(long a, long b, long c) {

		if (b == 1)
			return a % c;
		long cur = recur(a, b / 2, c);
		cur = cur * cur % c;
		if (b % 2 == 0)
			return cur;
		return cur * a % c;
	}
}
