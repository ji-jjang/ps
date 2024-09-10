import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				long c = Long.parseLong(st.nextToken());

				System.out.println(recur(a, b, c));
    }

		static long recur(long a, long b, long c) {
			if (b == 1)
				return a % c;
			long cur = recur(a, b / 2, c);
			cur = cur * cur % c;
			if (b % 2 == 0)
				return cur;
			return a * cur % c;
		}
}
