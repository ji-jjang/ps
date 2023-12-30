#include <iostream>
using namespace std;

int n, m;
bool isVisited[10];
int selected[10];

void dfs(int depth) {
	if (depth == m) {
		for (int i = 0; i < m; ++i) {
			cout << selected[i] << ' ';
		}
		cout << '\n';
		return ;
	}
	for (int i = 0; i < n; ++i) {
		if (!isVisited[i]) {
			isVisited[i] = true;
			selected[depth] = i + 1;
			dfs(depth + 1);	
			isVisited[i] = false;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	dfs(0);
}
