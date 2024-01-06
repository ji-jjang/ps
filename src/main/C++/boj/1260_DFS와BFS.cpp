#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int n, m, v;
bool vis[1004];
vector<int> adj[1004];

void dfs(int cur) {
	vis[cur] = true;
	cout << cur << ' ';
	for (auto nxt : adj[cur]) {
		if (vis[nxt]) continue ;
		dfs(nxt);
	}
}

void bfs(int cur) {
	queue<int> q;
	vis[cur] = true;
	q.push(cur);
	while (!q.empty()) {
		auto cur = q.front();
		q.pop();
		cout << cur << ' ';
		for (auto nxt : adj[cur]) {
			if (vis[nxt]) continue;
			vis[nxt] = true;
			q.push(nxt);
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m >> v;
	for (int i = 0; i < m; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	for (int i = 0; i < 1004; ++i) {
		sort(adj[i].begin(), adj[i].end());
	}
	dfs(v);
	cout << '\n';
	fill(vis, vis + 1004, 0);
	bfs(v);
}
