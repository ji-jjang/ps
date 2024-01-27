#include <iostream>
#include <vector>
using namespace std;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, -1, 0, 1};
int n;
int grid[104][104];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);	
	cin >> n;
	vector<int> dir;
	while (n--) {
		int x, y, d, g;
		cin >> x >> y >> d >> g;
		dir.push_back(d);
		while (g--) {
			int vSize = dir.size();
			for (int i = vSize - 1; i >= 0; --i)
				dir.push_back((dir[i] + 1) % 4);
		}
		grid[y][x] = 1;
		for (int i = 0; i < (int)dir.size(); ++i) {
			x += dx[dir[i]];
			y += dy[dir[i]];
			grid[y][x] = 1;
		}
		dir.clear();
	}
	int ans = 0;
	for (int i = 0; i < 101; ++i) {
		for (int j = 0; j < 101; ++j) {
			if (grid[i][j] == 1 && grid[i][j + 1] == 1 && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1)
				++ans;
		}
	}
	cout << ans;
}
