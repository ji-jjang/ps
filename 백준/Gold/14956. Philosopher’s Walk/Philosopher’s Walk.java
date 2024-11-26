import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken()) - 1;

		int[] ans = recur(n, m);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] recur(long n, long m) {

		if (n == 2) {
			if (m == 0) {
				return new int[]{1, 1};
			} else if (m == 1) {
				return new int[]{1, 2};
			} else if (m == 2) {
				return new int[]{2, 2};
			} else if (m == 3) {
				return new int[]{2, 1};
			}
		}

		long nn = n / 2;
		long quadrant = m / (nn * nn);
		long mm = m % (nn * nn);

		int[] coord = recur(nn, mm);

		int tmp = coord[0];
		if (quadrant == 0) {
			coord[0] = coord[1];
			coord[1] = tmp;
		} else if (quadrant == 1) {
			coord[1] += nn;
		} else if (quadrant == 2) {
			coord[0] += nn;
			coord[1] += nn;
		} else if (quadrant == 3) {
			coord[0] = (int)(2 * nn - coord[1] + 1);
			coord[1] = (int)(nn - tmp + 1);
		}

		return coord;
	}
}
