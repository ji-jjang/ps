import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String str = br.readLine();

			int[] alpha = new int[26];
			for (char c : str.toCharArray()) alpha[c - 'a']++;

			for (int i = 0; i < 26; ++i) bw.write(alpha[i] + " ");
			bw.flush();
	}
}
