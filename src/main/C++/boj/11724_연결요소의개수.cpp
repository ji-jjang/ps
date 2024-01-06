#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int n, m;
vector<int> adj[1004];
bool vis[1004];

void dfs(int cur) {
	stack<int> s;
	s.push(cur);
	while (!s.empty()) {
		auto cur = s.top();
		s.pop();
		if (vis[cur])
			continue ;
		vis[cur] = true;
		for (auto nxt : adj[cur]) {
			if (vis[nxt]) continue ;
			s.push(nxt);
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	
	cin >> n >> m;
	for (int i = 1; i <= m; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	int ans = 0;
	for (int i = 1; i <= n; ++i) {
		if (!vis[i]) {
			dfs(i);
			++ans;
		}
	}
	cout << ans;
}
