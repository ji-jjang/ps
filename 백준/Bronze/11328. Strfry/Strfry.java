import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] checker = new int[26];
			char[] str1 = st.nextToken().toCharArray();
			for (var c : str1) checker[c - 'a']++;

			char[] str2 = st.nextToken().toCharArray();
			for (var c : str2) checker[c - 'a']--;

			boolean isStrfry = true;
			for (int j = 0; j < 26; ++j) if (checker[j] != 0) isStrfry = false;

			String ans = isStrfry ? "Possible\n" : "Impossible\n";
			bw.write(ans);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
