import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] stu = new int[2][6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			stu[gender][grade - 1]++;
		}

		int ans = 0;
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 6; ++j) {
				if (stu[i][j] == 0) continue;
				int share = stu[i][j] / k;
				int remainder = stu[i][j] % k != 0 ? 1 : 0;
				ans += (share + remainder);
			}
		}
	
		System.out.println(ans);
		br.close();
	}
}
