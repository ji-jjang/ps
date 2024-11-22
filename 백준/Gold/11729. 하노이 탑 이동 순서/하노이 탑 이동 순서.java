import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		sb.append((int)(Math.pow(2, n)) - 1 + "\n");
		recur(n, 1, 3, sb);

		System.out.println(sb);
	}

	static void recur(int n, int a, int c, StringBuilder sb) {

		if (n == 1) {
			sb.append(a + " " + c + "\n");
			return;
		}
		int mid = 6 - a - c;
		recur(n - 1, a, mid, sb);
		sb.append(a + " " + c + "\n");
		recur(n - 1, mid, c, sb);
	}
}
