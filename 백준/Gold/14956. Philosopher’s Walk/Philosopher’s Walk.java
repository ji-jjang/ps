import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] ans = recur(n, m - 1);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] recur(long n, long m) {

		int[] coord = new int[2];
		if (n == 2) {
			if (m == 0) {
				coord[0] = 1; coord[1] = 1;
				return coord;
			}
			if (m == 1) {
				coord[0] = 1; coord[1] = 2;
				return coord;
			}
			if (m == 2) {
				coord[0] = 2; coord[1] = 2;
				return coord;
			}
			if (m == 3) {
				coord[0] = 2; coord[1] = 1;
				return coord;
			}
		}

		long nn = (n >> 1);
		long quadrant = m / (nn * nn);
		long mm = m % (nn * nn);
		coord = recur(nn, mm);

		if (quadrant == 0) {
			int tmp = coord[0];
			coord[0] = coord[1];
			coord[1] = tmp;
			return coord;
		}
		if (quadrant == 1) {
			coord[1] += nn;
			return coord;
		}
		if (quadrant == 2) {
			coord[0] += nn;
			coord[1] += nn;
			return coord;
		}

		int tmp = coord[0];
		coord[0] = (int)(2 * nn - coord[1] + 1);
		coord[1] = (int)(nn - tmp + 1);
		return coord;
	}
}

