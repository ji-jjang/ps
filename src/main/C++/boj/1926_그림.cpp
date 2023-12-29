#include <iostream>
#include <queue>
using namespace std;

int r, c;
int board[501][501];
bool isVisited[501][501];
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};
int pictureCnt = 0;
int maxSize = 0;

void bfs(int y, int x) {
	queue<pair<int, int>> Q;
	isVisited[y][x] = true;
	Q.push({y, x});
	
	int cnt = 0;
	while (!Q.empty()) {
		auto cur = Q.front();
		++cnt;
		Q.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c)
				continue ;
			if (board[ny][nx] == 0 || isVisited[ny][nx])
				continue ;
			isVisited[ny][nx] = true;
			Q.push({ny, nx});
		}	
	}
	maxSize = max(maxSize, cnt);
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> r >> c;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			cin >> board[i][j];
		}
	}
	
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			if (!isVisited[i][j] && board[i][j]) {
				++pictureCnt;
				bfs(i, j);
			}
		}
	}
	cout << pictureCnt << '\n' << maxSize << '\n';
}
