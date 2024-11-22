import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		int n = Integer.parseInt(tokens[0]);
		int r = Integer.parseInt(tokens[1]);
		int c = Integer.parseInt(tokens[2]);

		System.out.println(recur(n, r, c));
	}

	static int recur(int n, int r, int c) {

		if (n == 0) {
			return 0;
		}
		int half = 1 << (n - 1);

		if (r < half && c < half) {

			return recur(n - 1, r, c); 
		}
		else if (r < half && c >= half) {

			return half * half + recur(n - 1, r, c - half);
		}
		else if (r >= half && c < half) {

			return 2 * half * half + recur(n - 1, r - half, c);
		}

		return 3 * half * half + recur(n - 1, r - half, c - half);
	}
}
