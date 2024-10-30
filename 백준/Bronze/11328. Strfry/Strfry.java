import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] isVisited = new int[26];
			boolean isStrfry = true;

			for (var c : st.nextToken().toCharArray()) isVisited[c - 'a']++;
			for (var c : st.nextToken().toCharArray()) isVisited[c - 'a']--;

			for (var e : isVisited) {
				if (e != 0) {
					isStrfry = false;
					break;
				}
			}

			if (isStrfry) {
				sb.append("Possible\n");
				continue;
			}
			sb.append("Impossible\n");
		}
		System.out.println(sb);
	}
}

