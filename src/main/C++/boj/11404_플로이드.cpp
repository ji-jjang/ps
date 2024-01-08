#include <iostream>
#include <algorithm>
using namespace std;

int city[104][104];
const int INF = 0x3fffffff;
int main(void) {
	for (int i = 1; i <= n; ++i)
		fill(city[i], city[i] + n + 1, INF);
	for (int i = 1; i <= m; ++i) {
		int u, v, cost;
		cin >> u >> v >> cost;
		city[u][v] = min(city[u][v], cost);
	}
	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (i == j) continue; 
				city[i][j] = min(city[i][j], city[i][k] + city[k][j]);
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
}

