#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

string board[14];
int dy[] = {-1, 0, 1, 0}; 
int dx[] = {0, 1, 0, -1};
bool isVisited[14][14];
void drop(int row, int col) {
	if (row >= 12 || board[row + 1][col] != '.')
		return ;
	board[row + 1][col] = board[row][col];
	board[row][col] = '.';
	drop(row + 1, col);
}

bool erase(int y, int x, char c) {
	queue<pair<int, int>> q;
	queue<pair<int, int>> path;
	isVisited[y][x] = true;
	q.push({y, x});
	bool canErase = false;
	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		path.push(cur);
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= 12 || nx < 0 || nx >= 12)
				continue;
			if (board[ny][nx] != c || isVisited[ny][nx])
				continue;
			isVisited[ny][nx] = true;
			q.push({ny, nx});
		}
	}	
	if (path.size() >= 4)
		canErase = true;
	while (!path.empty()) {
		auto cur = path.front(); 
		if (canErase)
			board[cur.first][cur.second] = '.';
		path.pop();
	}
	return canErase;
}

bool bomb() {
	bool isBoomed = false;
	for (int i = 0; i < 12; ++i) {
		for (int j = 0; j < 6; ++j) {
			if (board[i][j] != '.') {
				if (erase(i, j, board[i][j]))
					isBoomed = true;
			}
		}
	}
	return isBoomed;
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	for (int i = 0; i < 12; ++i)
		cin >> board[i];
	int ans = 0;
	while (1) {
		for (int i = 0; i < 12; ++i) 
			fill(isVisited[i], isVisited[i] + 6, 0);
		if (!bomb()) 
			break;
		for (int col = 0; col < 6; ++col) {
			for (int row = 11; row >= 0; --row) {
				if (board[row][col] != '.')
					drop(row, col);		
			}
		}
		++ans;
	}
	cout << ans;
}
//		for (int i = 0; i < 12; ++i)
//			cout << board[i] << '\n';
	// .이 아니면 bfs를 한다. 4칸 이상 연결되어 있다면 지운다. 4칸이상 지웠을 때 true를 반환하는 bfs
	// 못지웠다면 다시 0으로
	// 지웠다면 1로
