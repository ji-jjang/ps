#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int board[5][5][5];
int tmp[5][5][5];
int ans = 1e9;
int dz[] = {0, 0, 0, 0, 1, -1};
int dy[] = {-1, 0, 1, 0, 0, 0};
int dx[] = {0, 1, 0, -1, 0, 0};

void rotate(int index, int cnt) {
	if (cnt == 0)
		return;
	int rTmp[5][5];
	while (cnt--) {
		for (int j = 0; j < 5; ++j) {
			for (int k = 0; k < 5; ++k)
				rTmp[j][k] = tmp[index][j][k];
		}
		for (int j = 0; j < 5; ++j) {
			for (int k = 0; k < 5; ++k)
				tmp[index][k][5 - j - 1] = rTmp[j][k];
		}
	}
}

void escape(vector<int>& seq, vector<int>& rSeq) {
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 5; ++j) {
			for (int k = 0; k < 5; ++k)
				tmp[i][j][k] = board[seq[i]][j][k];
		}
	}
	for (int i = 0; i < 5; ++i) 
		rotate(i, rSeq[i]);
	if (tmp[0][0][0] == 0 || tmp[4][4][4] == 0)
		return ;
	bool isVisited[5][5][5] = {};
	queue<tuple<int, int, int, int>> q;
	isVisited[0][0][0] = true;
	q.push({0, 0, 0, 0});
	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		int z = get<0>(cur);
		int y = get<1>(cur);
		int x = get<2>(cur);
		int cnt = get<3>(cur);
		if (cnt >= ans)
			return ;
		if (z == 4 && y == 4 && x == 4) {
			ans = min(ans, cnt);
			return ;
		}
		for (int dir = 0; dir < 6; ++dir) {
			int nz = z + dz[dir];
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (nz < 0 || nz >= 5 || ny < 0 || ny >= 5 || nx < 0 || nx >= 5) 
				continue;
			if (isVisited[nz][ny][nx] || tmp[nz][ny][nx] == 0) 
				continue;
			isVisited[nz][ny][nx] = true;
			q.push({nz, ny, nx, cnt + 1});
		}
	}
}

void findRotation(int depth, vector<int>& seq, vector<int>& rSeq) {
	if (depth == 5) {
		escape(seq, rSeq);
		return; 
	}
	for (int dir = 0; dir < 4; ++dir) {
		rSeq.push_back(dir);
		findRotation(depth + 1, seq, rSeq);
		rSeq.pop_back();
	}
}

void findBoard(int depth, vector<int>& seq, vector<bool>& isSelected) {
	if (depth == 5) {
		vector<int> rSeq;
		findRotation(0, seq, rSeq);
		return;
	}
	for (int i = 0; i < 5; ++i) {
		if (isSelected[i]) continue;
		seq.push_back(i);
		isSelected[i] = true;
		findBoard(depth + 1, seq, isSelected);
		seq.pop_back();	
		isSelected[i] = false;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 5; ++j) {
			for (int k = 0; k < 5; ++k)
				cin >> board[i][j][k];
		}
	}
	vector<int> seq;
	vector<bool> isSelected(5, false);
	findBoard(0, seq, isSelected);
	if (ans == 1e9)
		ans = -1;
	cout << ans;
}
