import java.io.*;
import java.util.*;


public class Main {

	static int[][] wheel = new int[4][8];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; ++i) {
			String line = br.readLine();
			for (int j = 0; j < 8; ++j) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			boolean[] isRotate = new boolean[4];
			int[] wheelDir = new int[4];
			checkRotate(idx, dir, isRotate, wheelDir);
			rotate(idx, dir, isRotate, wheelDir);
		}
		int ans = 0;
		for (int i = 0; i < 4; ++i) {
			if (wheel[i][0] == 1) {
				ans += (1 << i);
			}
		}
		System.out.println(ans);
	}

	public static void rotate(int idx, int dir, boolean[] isRotate, int[] wheelDir) {

		int[] tmp = new int[8];
		for (int i = 0; i < 4; ++i) {
			if (isRotate[i]) {
				if (wheelDir[i] == 1) {
					for (int j = 0; j < 8; ++j) {
						tmp[(j + 1) % 8] = wheel[i][j];
					}
				}
				else {
					for (int j = 0; j < 8; ++j) {
						int index = j - 1;
						if (index < 0)
							index = 7;
						tmp[index] = wheel[i][j];
					}
				}
				for (int j = 0; j < 8; ++j) {
					wheel[i][j] = tmp[j];
				}
			}
		}
	}

	public static void checkRotate(int idx, int dir, boolean[] isRotate, int[] wheelDir) {

		isRotate[idx] = true;
		wheelDir[idx] = dir;
		int newDir = dir;
		for (int i = idx; i < 3; ++i) {
			if (wheel[i][2] != wheel[i + 1][6]) {
				newDir *= -1;
				isRotate[i + 1] = true;
				wheelDir[i + 1] = newDir;
			}
			else
				break;
		}

		newDir = dir;
		for (int i = idx; i >= 1; --i) {
			if (wheel[i][6] != wheel[i - 1][2]) {
				newDir *= -1;
				isRotate[i - 1] = true;
				wheelDir[i - 1] = newDir;
			}
			else
				break;
		}
	}
}
