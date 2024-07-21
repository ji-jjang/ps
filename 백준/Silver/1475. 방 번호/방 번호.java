import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nums = br.readLine();
		int[] ret = new int[10];
		for (char c : nums.toCharArray()) {
			if (c == '6' || c == '9') ret[6]++;
			else ret[c - '0']++;
		}
		ret[6] = ret[6] % 2 == 0 ? ret[6] / 2 : ret[6] / 2 + 1;
		int ans = 0;
		for (int i = 0; i < 9; ++i) {
			ans = Math.max(ans, ret[i]);
		}
		bw.write(ans + '0');
		bw.flush();
		bw.close();
		br.close();
	}
}
