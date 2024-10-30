import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[10];

		while (n > 0) {
			cnt[n % 10]++;
			n /= 10;
		}
		cnt[6] += cnt[9]; 

		int ans = 0;
		for (int i = 0; i < 9; ++i) {
			if (i != 6 && ans < cnt[i]) {
				ans = cnt[i];
			}
		}
		if (ans <= cnt[6] / 2) {
			ans = cnt[6] / 2;
			if (cnt[6] % 2 == 1) ++ans;
		}

		System.out.println(ans);
	}

}
