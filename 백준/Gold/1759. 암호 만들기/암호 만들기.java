import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int l = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[] seq = new char[l];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; ++i) {
			sb.append(st.nextToken().charAt(0));
		}
		char[] chars = sb.toString().toCharArray();
		Arrays.sort(chars);
		sb.setLength(0);
		dfs(0, 0, l, c, chars, seq, sb);
		System.out.println(sb);
	}

	public static void dfs(int depth, int st, int l, int c, char[] chars, char[] seq, StringBuilder sb) {

		if (depth == l) {
			if (isValid(seq)) {
				for (int i = 0; i < l; ++i) {
					sb.append(seq[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = st; i < c; ++i) {
			seq[depth] = chars[i];
			dfs(depth + 1, i + 1, l, c, chars, seq, sb);
		}
	}

	public static boolean isValid(char[] seq) {
		int aeiouCnt = 0;
		int otherCnt = 0;
		for (int i = 0; i < seq.length; ++i) {
			if (seq[i] == 'a' || seq[i] == 'e' || seq[i] == 'i' || seq[i] == 'o' || seq[i] == 'u')
				++aeiouCnt;
			else
				++otherCnt;
		}
		return (aeiouCnt >= 1 && otherCnt >= 2);
	}
}
