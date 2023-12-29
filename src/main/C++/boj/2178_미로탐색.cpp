#include <iostream>
#include <queue>
using namespace std;

string board[1001];
int r, c;
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};
bool isVisited[1001][1001];
int dist[1001][1001];

void bfs(int y, int x) {
	queue<pair<int, int>> Q;
	dist[y][x] = 1;
	Q.push({y, x});

	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c)
				continue; 
			if (board[ny][nx] == '0' || dist[ny][nx] != -1)
				continue ;
			dist[ny][nx] = dist[cur.first][cur.second] + 1;
			Q.push({ny, nx});
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> r >> c;
	for (int i = 0; i < r; ++i) {
		cin >> board[i];
	}
	for (int i = 0; i < r; ++i) {
		fill(dist[i], dist[i] + c, -1);
	}
	bfs(0, 0);
	cout << dist[r - 1][c - 1] << '\n';
}
