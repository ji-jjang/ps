import java.io.*;
import java.util.*;


public class Main {

	static int[][] board;
	static int[][][] sticker; // index, 2d point
	static int[][] stickerInfo; // index, {r, c}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		board = new int[44][44];
		sticker = new int[k][14][14];
		stickerInfo = new int[k][2];
		for (int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine());
			stickerInfo[i][0] = Integer.parseInt(st.nextToken());
			stickerInfo[i][1] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < stickerInfo[i][0]; ++j) {
				st = new StringTokenizer(br.readLine());
				for (int jj = 0; jj < stickerInfo[i][1]; ++jj) {
					sticker[i][j][jj] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int idx = 0; idx < k; ++idx) {
			for (int dir = 0; dir < 4; ++dir) {
				boolean isAttached = false;
				rotateSticker(idx, dir);
				for (int i = 0; i < r; ++i) {
					for (int j = 0; j < c; ++j) {
						if (canPutSticker(idx, i, j, r, c)) {
							isAttached = true;
							break;
						}
					}
					if (isAttached) break;
				}
				if (isAttached) break;
			}
		}

		int ans = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (board[i][j] == 1)
					++ans;
			}
		}
		System.out.println(ans);
	}

	public static void rotateSticker(int idx, int dir) {
		
		if (dir == 0)
			return;

		int[][] tmp = new int[14][14];

		for (int i = 0; i < stickerInfo[idx][0]; ++i) {
			for (int j = 0; j < stickerInfo[idx][1]; ++j) {
				tmp[j][stickerInfo[idx][0] - i - 1] = sticker[idx][i][j];
			}
		}

		int temp = stickerInfo[idx][0];
		stickerInfo[idx][0] = stickerInfo[idx][1];
		stickerInfo[idx][1] = temp;

		for (int i = 0; i < stickerInfo[idx][0]; ++i) {
			for (int j = 0; j < stickerInfo[idx][1]; ++j) {
				sticker[idx][i][j] = tmp[i][j];
			}
		}
	}

	public static boolean canPutSticker(int idx, int startY, int startX, int r, int c) {
		int stickerY = stickerInfo[idx][0];
		int stickerX = stickerInfo[idx][1];

		if (startY + stickerY > r || startX + stickerX > c) {
			return false;
		}
		for (int i = startY; i < startY + stickerY; ++i) {
			for (int j = startX; j < startX + stickerX; ++j) {
				if (sticker[idx][i - startY][j - startX] == 1 && board[i][j] != 0) {
					return false;
				}
			}
		}
		for (int i = startY; i < startY + stickerY; ++i) {
			for (int j = startX; j < startX + stickerX; ++j) {
				if (sticker[idx][i - startY][j - startX] == 1) {
					board[i][j] = sticker[idx][i - startY][j - startX];
				}
			}
		}
		return true;
	}
}
