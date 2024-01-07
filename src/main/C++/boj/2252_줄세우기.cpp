#include <iostream>
#include <queue>
using namespace std;

int n, m;
vector<int> adj[32'004];
int deg[32'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	for (int i = 0; i < m; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		deg[v]++;
	}	
	queue<int> q;
	for (int i = 1; i <= n; ++i) {
		if (deg[i] == 0)
			q.push(i);
	}
	while (!q.empty()) { 
		auto cur = q.front(); q.pop();
		cout << cur << ' ';
		for (auto nxt : adj[cur]) {
			--deg[nxt];
			if (deg[nxt] == 0)
				q.push(nxt);
		}
	}
}
