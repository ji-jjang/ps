#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
string board[14];
pair<int, int> red, blue;
int ans = 1e9;
int cnt = 0;
void dfs(int depth, vector<int>& seq) {
	if (depth == 10) {
		pair<int, int> r = red;
		pair<int, int> b = blue;
		bool isEnd = false;
		for (int i = 0; i < (int)seq.size(); ++i) {
		int dir = seq[i];
		if (i != 0 && seq[i] == seq[i - 1])
			continue;
		if (isEnd || (i + 1) >= ans)
			break; 
			auto [ry, rx] = r;
			auto [by, bx] = b;
			while (board[ry + dy[dir]][rx + dx[dir]] == '.') {
				ry += dy[dir];
				rx += dx[dir];
			}
			while (board[by + dy[dir]][bx + dx[dir]] == '.') {
				by += dy[dir];
				bx += dx[dir];
			}
			if (board[ry + dy[dir]][rx + dx[dir]] == '#'
					&& board[by + dy[dir]][bx + dx[dir]] == '#') {
				if (ry == by && rx == bx) {
					if (dir == 0)
						(r.first < b.first) ? ++by : ++ry;
					else if (dir == 1) 
						(r.second < b.second) ? --rx : --bx;
					else if (dir == 2)
						(r.first < b.first) ? --ry : --by;
					else 
						(r.second < b.second) ? ++bx : ++rx;
				}
				r = {ry, rx};
				b = {by, bx};
			}
			if (board[by + dy[dir]][bx + dx[dir]] == 'O')
				isEnd = true;
			if (board[ry + dy[dir]][rx + dx[dir]] == 'O') {
				if (isEnd)
					continue;
				isEnd = true;
				ans = min(ans, i + 1);
			}
		}
		return ;
	}
	for (int dir = 0; dir < 4; ++dir) {
		seq.push_back(dir);
		dfs(depth + 1, seq);
		seq.pop_back();	
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);	
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> board[i];
		for (int j = 0; j < m; ++j) {
			if (board[i][j] == 'R') {
				board[i][j] = '.';
				red = {i, j};
			}
			else if (board[i][j] == 'B') {
				board[i][j] = '.';
				blue = {i, j};
			}
		}
	}
	vector<int> seq;
	dfs(0, seq);
	if (ans == 1e9)
		ans = -1;
	cout << ans;
}
