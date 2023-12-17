#include <iostream>
#include <queue>
#include <stack>
#include <algorithm>
#include <memory.h>
using namespace std;

int N, M, V;
vector<int> adj[1001];
bool isVisited[1001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M >> V;
	for (int i = 0; i < M; ++i) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= N; ++i) {
		sort(adj[i].begin(), adj[i].end());
	}
	stack<int> s;
	s.push(V);
	while (!s.empty()) {
		int cur = s.top();
		s.pop();
		if (isVisited[cur]) continue ;
		isVisited[cur] = true;
		cout << cur << ' ';
		for (int i = 0; i < adj[cur].size(); ++i) {
			int nxt = adj[cur][adj[cur].size() - 1 - i];
			if (isVisited[nxt]) continue ;
			s.push(nxt);
		}
	}
	memset(isVisited, 0, sizeof(isVisited));
	cout << '\n';
	queue<int> q;
	q.push(V);
	isVisited[V] = true;
	while (!q.empty()) {
		int cur = q.front();
		cout << cur << ' ';
		q.pop();
		for (auto nxt : adj[cur]) {
			if (isVisited[nxt]) continue ;
			q.push(nxt);
			isVisited[nxt] = true;
		}
	}
}
