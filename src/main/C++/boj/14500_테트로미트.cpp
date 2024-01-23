#include <iostream>
#include <vector>
using namespace std;

int n, m;
int paper[504][504];
int ans = 0;
vector<vector<vector<int>>> shape {
	{{1, 1, 1, 1}},
	{{1},{1},{1},{1}},	
	{{1, 1}, {1, 1}},
	{{1, 0}, {1, 0}, {1, 1}},
	{{0, 1}, {0, 1}, {1, 1}},
	{{1, 1, 1}, {1, 0, 0}},
	{{1, 1, 1}, {0, 0, 1}},
	{{1, 1}, {0, 1}, {0, 1}},
	{{1, 1}, {1, 0}, {1, 0}},
	{{0, 0, 1}, {1, 1, 1}},
	{{1, 0, 0}, {1, 1, 1}},
	{{1, 0}, {1, 1}, {0, 1}},
	{{0, 1}, {1, 1}, {1, 0}},
	{{0, 1, 1}, {1, 1, 0}},
	{{1, 1, 0}, {0, 1, 1}},
	{{1, 1, 1}, {0, 1, 0}},
	{{0, 1}, {1, 1}, {0, 1}},
	{{1, 0}, {1, 1}, {1, 0}},
	{{0, 1, 0}, {1, 1, 1}}
};

void checkScore(int index, int y, int x) {
	int r = shape[index].size();
	int c = shape[index][0].size();
	if (y + r > n || x + c > m)
		return ;
	int score = 0;
	for (int i = y; i < y + r; ++i) {
		for (int j = x; j < x + c; ++j) {
			if (shape[index][i - y][j - x] == 1) 
				score += paper[i][j];
		}
	}
	ans = max(ans, score);
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
			for (int k = 0; k < (int)shape.size(); ++k) {
				checkScore(k, i, j);
			}
		}
	}
	cout << ans;
}
