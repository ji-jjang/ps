#include <iostream>
#include <algorithm>
using namespace std;

int city[104][104];
int nxt[104][104];
const int INF = 0x3fffffff;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; ++i)
		fill(city[i], city[i] + n + 1, INF);
	for (int i = 1; i <= m; ++i) {
		int u, v, cost;
		cin >> u >> v >> cost;
		city[u][v] = min(city[u][v], cost);
		nxt[u][v] = v;
	}
	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j || i == k || k == j) continue; 
				if (city[i][j] > city[i][k] + city[k][j]) {
					city[i][j] = city[i][k] + city[k][j];
					nxt[i][j] = nxt[i][k];
				}
			}
		}
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (city[i][j] == INF)
				city[i][j] = 0;
			cout << city[i][j] << ' ';
		}
		cout << '\n';
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (city[i][j] == 0 || city[i][j] == INF) {
				cout << 0 << '\n';
				continue;
			}
			vector<int> path;
			int st = i;
			while (st != j) {
				path.push_back(st);
				st = nxt[st][j];
			}
			path.push_back(j);
			cout << path.size() << ' ';
			for (auto x : path) cout << x << ' ';
			cout << '\n';
		}
	}
}
