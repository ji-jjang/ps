import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; ++i) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(nums);
		int l = 0;
		int r = nums.length - 1;
		int ans = 0;
		while (l < r) {
			if (nums[l] + nums[r] == x) {
				++ans;
				++l;
			}
			else if (nums[l] + nums[r] < x) ++l;
			else --r;
		}

		System.out.println(ans);
	}
}

