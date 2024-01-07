#include <iostream>
#include <vector>
#include <tuple>
#include <queue>
#include <algorithm>
using namespace std;

int v, e;
vector<pair<int, int>> adj[10'004]; // cost, vertex
bool chk[10'004]; // mst
priority_queue<tuple<int, int, int>,
			   vector<tuple<int, int, int>>,
			   greater<tuple<int, int, int>>> pq; // cost, a, b

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> v >> e;
	for (int i = 0; i < e; ++i) {
		int a, b, cost;
		cin >> a >> b >> cost;
		adj[a].push_back({cost, b});
		adj[b].push_back({cost, a});
	}
	chk[1] = 1;
	for (auto nxt : adj[1]) {
		pq.push({nxt.first, 1, nxt.second});
	}
	int cnt = 0;
	int ans = 0;
	while (cnt < v - 1) {
		int a, b, cost;
		tie(cost, a, b) = pq.top(); pq.pop();
		if (chk[b]) continue;
		ans += cost;
		chk[b] = 1;
		++cnt;
		for (auto nxt: adj[b]) {
			if (!chk[nxt.second]) 
				pq.push({nxt.first, b, nxt.second});
		}
	}
	cout << ans;
}
