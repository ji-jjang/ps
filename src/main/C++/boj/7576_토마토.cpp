#include <iostream>
#include <queue>
using namespace std;

int r, c;
int box[1001][1001];
int dist[1001][1001];
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> c >> r;
	for (int i = 0; i < r; ++i) {
		fill(dist[i], dist[i] + c, -1);
	}
	queue<pair<int, int>> Q;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			cin >> box[i][j];
			if (box[i][j] == 1) {
				dist[i][j] = 0;
				Q.push({i, j});
			}
		}
	}
	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c)
				continue ;
			if (dist[ny][nx] != -1 || box[ny][nx] != 0)
				continue ;
			dist[ny][nx] = dist[cur.first][cur.second] + 1;
			Q.push({ny, nx});
		}
	}
//	cout << '\n';
//	for (int i = 0; i < r; ++i) {
//		for (int j = 0; j < c; ++j) {
//			cout << dist[i][j] << ' ';
//		}
//		cout << '\n';
//	}
//	cout << '\n';
	bool isFill = true;
	int minDay = 0;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			minDay = max(minDay, dist[i][j]);
			if (box[i][j] == 0 && dist[i][j] == -1) {
				isFill = false;
				break;
			}	
		}
		if (!isFill)
			break;
	}
	if (!isFill)
		cout << -1 << '\n';
	else
		cout << minDay << '\n';

}
