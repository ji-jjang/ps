import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] isVisited = new int[26];
		for (var c : br.readLine().toCharArray())
			isVisited[c - 'a']++;
		for (var c : br.readLine().toCharArray())
			isVisited[c - 'a']--;

		int ans = 0;
		for (int i = 0; i < 26; ++i)
			ans += Math.abs(isVisited[i]);

		System.out.println(ans);
	}
}
