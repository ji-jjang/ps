#include <iostream>
#include <vector>
using namespace std;

int n, m, h;
int lad[34][14];
vector<pair<int, int>> emp;
bool isStraight() {
	for (int col = 1; col <= n; ++col) {
		int sCol = col;
		int row = 0;
		while (row <= h) {
			if (lad[row][col] == 1)
				++col;
			else if (lad[row][col] == 2)
				--col;
			++row;
		}
		if (sCol != col)
			return false;
	}
	return true;
}

int dfs(int depth, int mx, int start) {
	if (depth == mx) {
		if (isStraight())
			return depth;
		return -1; }
	for (int i = start; i < (int)emp.size(); ++i) {
		if (lad[emp[i].first][emp[i].second] || lad[emp[i].first][emp[i].second + 1]) 
			continue;
		lad[emp[i].first][emp[i].second] = 1;
	   	lad[emp[i].first][emp[i].second + 1] = 2;
		if (dfs(depth + 1, mx, i + 1) > 0)
			return mx;
		lad[emp[i].first][emp[i].second] = 0;
	   	lad[emp[i].first][emp[i].second + 1] = 0;
	}
	return -1;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> h;
	for (int i = 0; i < m; ++i) {
		int l, r;
		cin >> l >> r;
		lad[l][r] = 1;
		lad[l][r + 1] = 2;
	}
	for (int i = 1; i <= h; ++i) {
		for (int j = 1; j < n; ++j) {
			if (lad[i][j] == 0 && lad[i][j + 1] == 0)
				emp.push_back({i, j});
		}
	}
	int ans = -1;
	for (int i = 0; i <= 3; ++i) {
		ans = dfs(0, i, 0);
		if (ans != -1)
			break;
	}
	cout << ans;
}
