#include <iostream>
using namespace std;

const int INF = 0x3fffffff;
int dist[102][102];
int n, m;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; ++i) {
		fill(dist[i], dist[i] + n + 1, INF);
	}
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		dist[a][b] = min(dist[a][b], c);
	}
	for (int i = 1; i <= n; ++i)
		dist[i][i] = 0;
	for (int k = 1; k <= n; ++k) {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (dist[i][j] == INF) cout << "0 ";
			else cout << dist[i][j] << ' ';
		}
		cout << '\n';
	}
}
