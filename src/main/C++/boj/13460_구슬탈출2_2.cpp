#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n, m;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
string board[14];
int dist[14][14][14][14];
pair<int, int> red, blue;
int bfs() {
	queue<tuple<int, int, int, int>> q;
	q.push({red.first, red.second, blue.first, blue.second});
	dist[red.first][red.second][blue.first][blue.second] = 0;
	while (!q.empty()) {
		auto [ry, rx, by, bx] = q.front();
		q.pop();
		int cnt = dist[ry][rx][by][bx];
		if (cnt >= 10)
			return -1;
		for (int dir = 0; dir < 4; ++dir) {
			int rry = ry, rrx = rx, bby = by, bbx = bx;
			while (board[bby + dy[dir]][bbx + dx[dir]] == '.') {
				bby += dy[dir];
				bbx += dx[dir];
			}
			if (board[bby + dy[dir]][bbx + dx[dir]] == 'O')
				continue;
			while (board[rry + dy[dir]][rrx + dx[dir]] == '.') {
				rry += dy[dir];
				rrx += dx[dir];
			}
			if (board[rry + dy[dir]][rrx + dx[dir]] == 'O')
				return cnt + 1;
			if (board[rry + dy[dir]][rrx + dx[dir]] == '#'
					&& board[bby + dy[dir]][bbx + dx[dir]] == '#') {
				if (rry == bby && rrx == bbx) {
					if (dir == 0)
						(ry < by) ? ++bby : ++rry;
					else if (dir == 1) 
						(rx < bx) ? --rrx : --bbx;
					else if (dir == 2)
						(ry < by) ? --rry : --bby;
					else 
						(rx < bx) ? ++bbx : ++rrx;
				}
			}
			if (dist[rry][rrx][bby][bbx] != -1)
				continue;
			dist[rry][rrx][bby][bbx] = cnt + 1;
			q.push({rry, rrx, bby, bbx});
		}	
	}
	return -1;
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
	for (int i = 0; i < 10; ++i) {
		for (int j = 0; j < 10; ++j) {
			for (int k = 0; k < 10; ++k) {
				fill(dist[i][j][k], dist[i][j][k] + 10, -1);
			}
		}
	}
	cout << bfs();
}
