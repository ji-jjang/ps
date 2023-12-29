#include <iostream>
#include <queue>
using namespace std;

int r, c;
string maze[1001];
int jdist[1001][1001];
int fdist[1001][1001];
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> r >> c;

	for (int i = 0; i < r; ++i) {
		fill(jdist[i], jdist[i] + c, -1);
		fill(fdist[i], fdist[i] + c, -1);
	}
	queue<pair<int, int>> jq;
	queue<pair<int, int>> fq;
	for (int i = 0; i < r; ++i) {
		cin >> maze[i];
		for (int j = 0; j < c; ++j) {
			if (maze[i][j] == 'J') {
				jdist[i][j] = 0;
				jq.push({i, j});
			}
			if (maze[i][j] == 'F') {
				fdist[i][j] = 0;
				fq.push({i, j});
			}
		}
	}
	while (!fq.empty()) {
		auto cur = fq.front();
		fq.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c)
				continue ;
			if (maze[ny][nx] == '#' || fdist[ny][nx] != -1)
				continue ;
			fdist[ny][nx] = fdist[cur.first][cur.second] + 1;
			fq.push({ny, nx});
		}
	}
	bool isPossible = false;
	int ans = 0;
	while (!jq.empty()) {
		auto cur = jq.front();
		jq.pop();
		if (cur.first == 0 || cur.first == r - 1
				|| cur.second == 0 || cur.second == c- 1) {
			isPossible = true;	
			ans = jdist[cur.first][cur.second];
			break;
		}
		for (int dir = 0; dir < 4; ++dir) {
			int ny = cur.first + dy[dir];
			int nx = cur.second + dx[dir];
			if (ny < 0 || ny >= r || nx < 0 || nx >= c)
				continue ;
			if (maze[ny][nx] != '.' || jdist[ny][nx] != -1 || (jdist[cur.first][cur.second] + 1 >= fdist[ny][nx] && fdist[ny][nx] != -1))
				continue ;
			jdist[ny][nx] = jdist[cur.first][cur.second] + 1;
			jq.push({ny, nx});
		}
	}
//	cout << '\n';
//	for (int i = 0; i < r; ++i) {
//		for (int j = 0; j < c; ++j) {
//			cout << fdist[i][j] << ' ';
//		}
//		cout << '\n';
//	}
//	cout << '\n';
//	for (int i = 0; i < r; ++i) {
//		for (int j = 0; j < c; ++j) {
//			cout << jdist[i][j] << ' ';
//		}
//		cout << '\n';
//	}
//	cout << '\n';
	if (isPossible) 
		cout << ans + 1 << '\n';
	else
		cout << "IMPOSSIBLE" << '\n';
}

// 
/*
7 7
#######
#J#F###
#......
#######
#######
#######
#######

7 7
#######
#FJ####
#......
#######
#######
#######
#######

7 7
#######
#JF####
#......
#######
#######
#######
#######

7 7
#######
.J.####
#F.....
#######
#######
#######
#######

7 7
#######
#F#J###
#F#....
#######
###F##F
#######
#######
*/
