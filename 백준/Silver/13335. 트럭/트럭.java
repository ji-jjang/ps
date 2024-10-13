
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] truck = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			truck[i] = Integer.parseInt(st.nextToken());
		}

		int[] bridge = new int[w + 1];
		int idx = 0;
		int time = 0;
		int curWeight = 0;
		while (idx < n || curWeight > 0) {
			++time;
			curWeight -= bridge[w - 1];
			for (int i = w - 1; i >= 0; --i) {
				bridge[i + 1] = bridge[i];
			}
			bridge[0] = 0;

			if (idx < n && curWeight + truck[idx] <= l) {
				bridge[0] = truck[idx];
				curWeight += truck[idx];
				++idx;
			}
		}
		System.out.println(time);
	}
}

