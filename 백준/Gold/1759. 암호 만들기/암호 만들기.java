import java.io.*;
import java.util.*;

public class Main {

	static int l, c;
	static char[] chars;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tokens = br.readLine().split(" ");

		l = Integer.parseInt(tokens[0]);
		c = Integer.parseInt(tokens[1]);

		chars = new char[c];
		tokens = br.readLine().split(" ");
		for (int i = 0; i < c; ++i) {
			chars[i] = tokens[i].charAt(0);
		}
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder();
		dfs(0, 0, new char[l], sb);
		System.out.println(sb);
	}

	static void dfs(int depth, int st, char[] selected, StringBuilder sb) {

		if (depth == l) {
			if (checkOneToCondition(selected)) {
				for (int i = 0; i < l; ++i) {
					sb.append(selected[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = st; i < c; ++i) {
			selected[depth] = chars[i];
			dfs(depth + 1, i + 1, selected, sb);
		}
	}

	static boolean checkOneToCondition(char[] selected) {

		int aCnt = 0;
		int bCnt = 0;
		for (var c : selected) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				++aCnt;
			} else {
				++bCnt;
			}
		}
		return (aCnt >= 1 && bCnt >= 2);
	}
}
