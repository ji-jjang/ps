#include <iostream>
using namespace std;

int n, l;
int map[104][104];
int ans = 0;
void rotate() {
	int tmp[104][104];
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			tmp[i][j] = map[i][j];
		}
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			map[j][n - i - 1] = tmp[i][j];
		}
	}
}

void checkRow() {
	for (int row = 0; row < n; ++row) {
		int flat = 0;
		int prev = map[row][0];
		bool isBridge[104] = {};
		for (int col = 0; col < n; ++col) {
			if (abs(map[row][col] - prev) > 1)
				break;
			if (prev > map[row][col]) {
				int nCol = col;
				int nFlat = 0;
				int nH = map[row][col];
				while (nCol < n) {
					if (nFlat == l || nH != map[row][nCol])
						break;
					isBridge[nCol] = true;
					++nFlat;
					++nCol;	
					nH = map[row][col];
				}
				if (nFlat < l)
					break;
				flat = 0;
			} else if (prev < map[row][col]) {
				if (flat < l)
					break;
				flat = 0;
			}
			if (!isBridge[col])
				++flat;
			prev = map[row][col];
			if (col == n - 1)
				++ans;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> l;	
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j)
			cin >> map[i][j];
	}
	checkRow();
	rotate();
	checkRow();
	cout << ans;
}
