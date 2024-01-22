#include <iostream>
#include <vector>
using namespace std;

int dice[4][3];
int tmp[4][3];
int map[24][24];
int dy[] = {0, 0, 0, -1, 1};
int dx[] = {0, 1, -1, 0, 0};
int n, m, y, x, k;
void rollRight() {
	dice[1][0] = tmp[3][1];
	dice[1][1] = tmp[1][0];
	dice[1][2] = tmp[1][1];
	dice[3][1] = tmp[1][2];
};

void rollLeft() {
	dice[1][0] = tmp[1][1];
	dice[1][1] = tmp[1][2];
	dice[1][2] = tmp[3][1];
	dice[3][1] = tmp[1][0];
};

void rollUp() {
	dice[0][1] = tmp[1][1];
	dice[1][1] = tmp[2][1];
	dice[2][1] = tmp[3][1];
	dice[3][1] = tmp[0][1];
};

void rollDown() {
	dice[0][1] = tmp[3][1];
	dice[1][1] = tmp[0][1];
	dice[2][1] = tmp[1][1];
	dice[3][1] = tmp[2][1];
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m >> y >> x >> k;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j)
			cin >> map[i][j];
	}	
	vector<int>path;
	while (k--) {
		int dir;
		cin >> dir;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= n || nx < 0 || nx >= m)
			continue;
		y = ny;
		x = ny;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 3; ++j)
				tmp[i][j] = dice[i][j];
		}
		if (dir == 1) 
			rollRight();
		else if (dir == 2)
			rollLeft();
		else if (dir == 3)
			rollUp();
		else
			rollDown();
		if (map[y][x] == 0) 
			map[y][x] = dice[3][1];
		else {
			dice[3][1] = map[y][x];
			map[y][x] = 0;
		}
		path.push_back(dice[1][1]);
	}
	for (int i = 0; i < (int)path.size(); ++i) {
		cout << path[i] << '\n';
	}
}
