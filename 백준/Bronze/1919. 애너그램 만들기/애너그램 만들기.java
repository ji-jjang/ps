import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str1 = br.readLine();
			String str2 = br.readLine();

			HashMap<Character, Integer> m= new HashMap<>();
			for (var c : str1.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);
			for (var c : str2.toCharArray()) m.put(c, m.getOrDefault(c, 0) - 1);
			int ans = 0;
			for (char c = 'a'; c <= 'z'; ++c) {
				ans += Math.abs(m.getOrDefault(c, 0));
			}
			System.out.println(ans);
			br.close();
	}
}
