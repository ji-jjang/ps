#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M;
vector<int> adj[32001];
int deg[32001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	while (M--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		deg[b]++;
	}
	queue<int> Q;
	for (int i = 1; i <= N; ++i) {
		if (deg[i] == 0) Q.push(i);
	}
	while (!Q.empty()) {
		int cur = Q.front(); Q.pop();
		cout << cur << ' ';
		for (int nxt : adj[cur]) {
			deg[nxt]--;
			if (deg[nxt] == 0)
				Q.push(nxt);
		}
	}
}
