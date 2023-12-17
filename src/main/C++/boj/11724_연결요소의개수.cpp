#include <iostream>
#include <queue>
#include <vector>
#include <stack>
using namespace std;

int N, M;
vector<int> adj[1001];
bool isVisited[1001];
int ans;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i <	M; ++i) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	for (int i = 1; i <= N; ++i) {
		if (isVisited[i]) continue ;
		++ans;
		queue<int> q;
		q.push(i);
		isVisited[i] = true;
		while (!q.empty()) {
			int cur = q.front();
			q.pop();
			if (isVisited[cur]) continue ;

			for (auto nxt : adj[cur]) {
				if (isVisited[nxt]) continue ;
				q.push(nxt);
			}
		}
	}
	cout << ans << '\n';
}
