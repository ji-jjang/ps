#include <iostream>
#include <vector>
using namespace std;

int n;
vector<int> adj[100'004];
int p[100'004];

void dfs(int cur) {
	for (auto nxt : adj[cur]) {
		if (p[cur] == nxt) continue ;
		p[nxt] = cur;
		dfs(nxt);
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n - 1; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	dfs(1);
	for (int i = 2; i <= n; ++i) {
		cout << p[i] << '\n';
	}
}
