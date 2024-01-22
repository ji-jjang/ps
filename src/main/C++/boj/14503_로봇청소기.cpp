#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int room[54][54];
int n, m;
int y, x, dir;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
	cin >> y >> x >> dir;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j)
			cin >> room[i][j];
	}
	queue<tuple<int, int, int>> q;
	q.push({y, x, dir});
	int ans = 0;
	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		int y = get<0>(cur);
		int x = get<1>(cur);
		int dir = get<2>(cur);
		if (room[y][x] == 0) {
			++ans;
			room[y][x] = 2;
		}
		bool isDirty = false;
		for (int direct = 0; direct < 4; ++direct) {
			int ny = y + dy[direct];
			int nx = x + dx[direct];
			if (room[ny][nx] == 0)
				isDirty = true;
		}
		if (!isDirty) {
			int ny = y - dy[dir];
			int nx = x - dx[dir];
			if (room[ny][nx] == 1)
				continue;
			q.push({ny, nx, dir});
		} else {
			dir -= 1;
			if (dir == -1) dir = 3;
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (room[ny][nx] == 0)
				q.push({ny, nx, dir});
			else
				q.push({y, x, dir});
		}
	}
	cout << ans;
}
