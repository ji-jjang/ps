#include <iostream>
using namespace std;

int n, m, k;
int note[44][44];
int sticker[14][14];
int r, c;
bool putSticker(int y, int x) {
	// checkSticker
	for (int i = y; i < y + r; ++i) {
		for (int j = x; j < x + c; ++j) {
			if (note[i][j] == 1 && sticker[i - y][j - x] == 1)
				return false;
		}
	}
	// put
	for (int i = y; i < y + r; ++i) {
		for (int j = x; j < x + c; ++j) {
			if (note[i][j] == 0)
				note[i][j] = sticker[i - y][j - x];
		}
	}
	return true;
}

void rotate() {
	int temp[14][14] = {};
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j)
			temp[j][r - i - 1] = sticker[i][j];
	}
	swap(r, c);
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j)
			sticker[i][j] = temp[i][j];
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> k;
	while (k--) {
		cin >> r >> c;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				cin >> sticker[i][j];
			}
		}
		bool isAttached = false;
		for (int ro = 0; ro < 4; ++ro) {
			if (isAttached)
				break;
			if (ro != 0)
				rotate();
			for (int i = 0; i <= n - r; ++i) {
				if (isAttached)
					break;
				for (int j = 0; j <= m - c; ++j) {
					if (putSticker(i, j)) {
						isAttached = true;
						break; 
					}
				}
			}
		}
	}
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (note[i][j] == 1)
				++ans;
		}
	}
	cout << ans;
}
