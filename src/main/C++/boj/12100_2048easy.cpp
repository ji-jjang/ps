#include <iostream>
#include <vector>
using namespace std;

int n;
int board[24][24];
int cBoard[24][24];
int ans = 0;
void push() {
	for (int col = 0; col < n; ++col) {
		int tmp[24] = {};
		int idx = 0;
		for (int row = 0; row < n; ++row) {
			if (cBoard[row][col] == 0)
				continue;
			if (tmp[idx] == 0)
				tmp[idx] = cBoard[row][col];
			else if (tmp[idx] != cBoard[row][col])
				tmp[++idx] = cBoard[row][col];
			else (tmp[idx] == cBoard[row][col])
				tmp[idx++] *= 2;
		}
		for (int i = 0; i < n; ++i)
			cBoard[i][col] = tmp[i];
	}
}

void rotate(int cnt) {
	if (cnt == 0 || cnt == 4)
		return ;
	while (cnt--) {
		int tmp[24][24] = {};
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				tmp[j][n - i - 1] = cBoard[i][j];
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				cBoard[i][j] = tmp[i][j];
		}
	}
}

void dfs(int depth, vector<int>& seq) {
	if (depth == 5) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				cBoard[i][j] = board[i][j];
		}
		int restoreCnt = 0;
		for (int i = 0; i < (int)seq.size(); ++i) {
			rotate(seq[i]);
			push();
			restoreCnt = 4 - seq[i];
			rotate(restoreCnt);
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				ans = max(ans, cBoard[i][j]);
		}
		return ;
	}
	for (int i = 0; i < 4; ++i) {
		seq.push_back(i);
		dfs(depth + 1, seq);
		seq.pop_back();
	}
}

int main(void) {
	ios::sync_with_stdio(false); cin.tie(nullptr);
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j)
			cin >> board[i][j];
	}
	vector<int> seq;
	dfs(0, seq);
	cout << ans;
}
