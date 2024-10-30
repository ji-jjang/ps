import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		int[] cnt = new int[26];

		for (var c : word.toCharArray()) {
			cnt[c - 'a']++;
		}
		for (var e : cnt) {
			System.out.printf(e + " ");
		}
	}
}
