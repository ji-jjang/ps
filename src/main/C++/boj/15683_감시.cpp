#include <iostream>
#include <vector>
using namespace std;

int n, m;
int room[14][14];
int cRoom[14][14];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int ans = 0x7fffffff;
vector<pair<int, int>> cctv;
vector<vector<vector<int>>> cctvDir = {
	{},
	{{0}, {1}, {2}, {3}},
	{{0, 2}, {1, 3}},
	{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
	{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
	{{0, 1, 2, 3}}
};

void WatchArea(int y, int x, int dir) {
	while (true) {
		y += dy[dir];
		x += dx[dir];
		if (y < 0 || x < 0 || y >= n || x >= m)
			break;
		if (cRoom[y][x] == 6)
			break; 
		if (cRoom[y][x] >= 1 && cRoom[y][x] <= 5)
			continue;
		cRoom[y][x] = 9;
	}
}

void dfs(int depth, vector<vector<int>>& seq) {
    if (depth == (int)cctv.size()) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				cRoom[i][j] = room[i][j];
			}
		}
		for (int i = 0; i < (int)seq.size(); ++i) {
			for (int j = 0; j < (int)seq[i].size(); ++j) {
				WatchArea(cctv[i].first, cctv[i].second, seq[i][j]);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (cRoom[i][j] == 0)
					++cnt;
			}
		}
		ans = min(ans, cnt);
        return;
    }
    int type = room[cctv[depth].first][cctv[depth].second];
    for (auto& dir : cctvDir[type]) {
        seq.push_back(dir);
        dfs(depth + 1, seq);
        seq.pop_back();
    }
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> room[i][j];
			if (room[i][j] >= 1 && room[i][j] <= 5)
				cctv.push_back({i, j});
		}
	}
    vector<vector<int>> seq;
    dfs(0, seq);
	cout << ans;
    return 0;
}
