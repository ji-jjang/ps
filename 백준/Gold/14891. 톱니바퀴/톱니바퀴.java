import java.util.*;
import java.io.*;

public class Main {

	static char[][] wheels = new char[4][8];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < 8; ++j) {
				wheels[i][j] = line[j];
			}
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] tokens = br.readLine().split(" ");
			int idx = Integer.parseInt(tokens[0]) - 1;
			int dir = Integer.parseInt(tokens[1]);
			int[] rotateWheels = new int[4];
			checkRotateWheel(rotateWheels, idx, dir);
			rotate(rotateWheels);
		}
		int ans = 0;
		for (int i = 0; i < 4; ++i) {
			if (wheels[i][0] == '1') {
				ans += (1 << i);
			}
		}
		System.out.println(ans);
	}

	static void checkRotateWheel(int[] rotateWheels, int idx, int dir) {

		rotateWheels[idx] = dir;

		int curDir = dir;
		for (int i = idx; i < 3; ++i) {
			if (wheels[i][2] != wheels[i + 1][6]) {
				curDir *= -1;
				rotateWheels[i + 1] = curDir;
			}
			else
				break;
		}
		curDir = dir;
		for (int i = idx; i >= 1; --i) {
			if (wheels[i][6] != wheels[i - 1][2]) {
				curDir *= -1;
				rotateWheels[i - 1] = curDir;
			}
			else
				break;
		}
	}

	static void rotate(int[] rotateWheels) {

		for (int i = 0; i < 4; ++i) {
			if (rotateWheels[i] == 1) {
				rotateClockwise(i);
			} else if (rotateWheels[i] == -1) {
				rotateCounterClockwise(i);
			}
		}
	}

	static void rotateClockwise(int idx) {

		char[] tmp = new char[8];
		for (int i = 0; i < 8; ++i) {
			tmp[i] = wheels[idx][i];
		}
		for (int i = 1; i < 8; ++i) {
			wheels[idx][i] = tmp[i - 1];
		}
		wheels[idx][0] = tmp[7];
	}

	static void rotateCounterClockwise(int idx) {

		char[] tmp = new char[8];
		for (int i = 0; i < 8; ++i) {
			tmp[i] = wheels[idx][i];
		}
		for (int i = 1; i < 8; ++i) {
			wheels[idx][i - 1] = tmp[i];
		}
		wheels[idx][7] = tmp[0];
	}
}
