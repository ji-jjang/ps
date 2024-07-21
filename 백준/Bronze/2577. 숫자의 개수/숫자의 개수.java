import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int[] ans = new int[10];
		int ret = a * b * c;
		while (ret > 0) {
			ans[ret % 10]++;
			ret /= 10;
		}

		for (int i = 0; i < 10; ++i) bw.write(ans[i] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
