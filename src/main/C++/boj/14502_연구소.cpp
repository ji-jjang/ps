#include <iostream>
#include <queue>
using namespace std;

int n, m;
int map[10][10];
vector<pair<int, int>> emp;
vector<pair<int, int>> virus;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int ans = 0;
void bfs(vector<pair<int, int>>& seq) {
	int tmp[10][10];
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j)
			tmp[i][j] = map[i][j];
	}
	for (int i = 0; i < (int)seq.size(); ++i)
		tmp[seq[i].first][seq[i].second] = 1;;
	queue<pair<int, int>> q;
	for (int i = 0; i < (int)virus.size(); ++i)
		q.push(virus[i]);
	while (!q.empty()) {
		auto [y, x] = q.front(); q.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny < 0 || ny >= n || nx < 0 || nx >= m)
				continue;
			if (tmp[ny][nx] != 0)
				continue;
			tmp[ny][nx] = 2;	
			q.push({ny, nx});
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (tmp[i][j] == 0)
				++cnt;
		}
	}
	ans = max(ans, cnt);
}

void dfs(int depth, vector<pair<int, int>>& seq, vector<bool>& isSelected) {
	if (depth == 3) {
		bfs(seq);
		return ;
	}
	for (int i = 0; i < (int)emp.size(); ++i) {
		if (isSelected[i])
			continue;
		isSelected[i] = true;
		seq.push_back(emp[i]);
		dfs(depth + 1, seq, isSelected);
		seq.pop_back();
		isSelected[i] = false;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> map[i][j];
			if (map[i][j] == 0)
				emp.push_back({i, j});
			else if (map[i][j] == 2) {
				virus.push_back({i, j});
			}
		}
	}
	vector<bool> isSelected(8, 0);
	vector<pair<int, int>> seq;
	dfs(0, seq, isSelected);
	cout << ans;
}
