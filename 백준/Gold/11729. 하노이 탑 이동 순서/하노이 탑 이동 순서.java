import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				int n = Integer.parseInt(br.readLine());

				StringBuilder sb = new StringBuilder();
				sb.append((int)Math.pow(2, n) - 1 + "\n");
				hanoi(n, 1, 3, sb);
				System.out.println(sb.toString());
    }

		static void hanoi(int n, int a, int c, StringBuilder sb) {
			if (n == 1) {
				sb.append(a + " " + c + "\n");
				return;
			}
			hanoi(n - 1, a, 6 - a - c, sb);
			sb.append(a + " " + c + "\n");
			hanoi(n - 1, 6 - a - c, c, sb);
		}
}
