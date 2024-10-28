import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] innings;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		innings = new int[n][9];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				innings[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] players = {1, 2, 3, 4, 5, 6, 7, 8};

		dfs(0, players, new boolean[8], new int[8]);
		System.out.println(ans);
	}

	static void dfs(int depth, int[] players, boolean[] isVisited, int[] orders) {
		if (depth == 8) {
			int[] lineup = new int[9];
			int idx = 0;
			for (int i = 0; i < 9; i++) {
				if (i == 3) {
					lineup[i] = 0;
				} else {
					lineup[i] = players[orders[idx++]];
				}
			}

			ans = Math.max(ans, startGame(lineup));
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				orders[depth] = i;
				dfs(depth + 1, players, isVisited, orders);
				isVisited[i] = false;
			}
		}
	}

	static int startGame(int[] orders) {

		int score = 0;
		int idx = 0;

		for (var inning : innings) {
			int outs = 0;
			boolean[] bases = new boolean[3];

			while (outs < 3) {
				int ret = inning[orders[idx]];
				switch (ret) {
					case 0:
						++outs;
						break;
					case 1:
						if (bases[2]) {
							++score;
						}
						for (int i = 2; i > 0; --i) {
							bases[i] = bases[i - 1];
						}
						bases[0] = true;
						break;
					case 2:
						for (int i = 2; i >= 1; --i) {
							if (bases[i]) {
								++score;
								bases[i] = false;
							}
						}
						bases[2] = bases[0];
						bases[0] = false;
						bases[1] = true;
						break;
					case 3:
						for (int i = 2; i >= 0; --i) {
							if (bases[i]) {
								++score;
								bases[i] = false;
							}
						}
						bases[2] = true;
						break;
					case 4:
						for (int i = 2; i >= 0; --i) {
							if (bases[i]) {
								++score;
								bases[i] = false;
							}
						}
						++score;
						break;
				}
				idx = (idx + 1) % 9;
			}
		}

		return score;
	}
}