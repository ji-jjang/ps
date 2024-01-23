#include <iostream>
#include <vector>
using namespace std;

int n, m;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int paper[504][504];
bool isVisited[504][504];
int ans = 0;
void dfs(int depth, int y, int x, int sum) {
	if (depth == 4) {
		ans = max(ans, sum);
		return;
	}
	for (int dir = 0; dir < 4; ++dir) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
		if (isVisited[ny][nx]) continue;
		sum += paper[ny][nx];
		isVisited[ny][nx] = true;
		dfs(depth + 1, ny, nx, sum);
		if (depth == 2)
			dfs(depth + 1, y, x, sum);
		sum -= paper[ny][nx];
		isVisited[ny][nx] = false;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j)
			cin >> paper[i][j];
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			isVisited[i][j] = true;
			dfs(1, i, j, paper[i][j]);
			isVisited[i][j] = false;
		}
	}
	cout << ans;
}
