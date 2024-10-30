import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ret = 1;
		for (int i = 0; i < 3; ++i) {
			ret *= Integer.parseInt(br.readLine());
		}

		int[] cnt = new int[10];
		while (ret > 0) {
			cnt[ret % 10]++;
			ret /= 10;
		}
		for (var e : cnt) {
			System.out.println(e);
		}
	}
}
