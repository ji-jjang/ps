import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] students = new int[2][7]; // gender, grade

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[gender][grade]++;
		}

		int ans = 0;
		for (int i = 0; i < 2; ++i) {
			for (int j = 1; j < 7; ++j) {
				int share = students[i][j] / k;
				int remainder = students[i][j] % k == 0 ? 0 : 1;
				ans += share + remainder;
			}
		}
		System.out.println(ans);
	}
}

