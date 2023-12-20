#include <iostream>
#include <queue>
#include <vector>
#include <tuple>

using namespace std;

int v, e;
vector<pair<int, int>> adj[10'001];
bool isChecked[10'001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> v >> e;
	for (int i = 0; i < e; ++i) {
		int a, b, cost;
		cin >> a >> b >> cost;
		adj[a].push_back({cost, b});
		adj[b].push_back({cost, a});
	}

	priority_queue<tuple<int, int, int>,
		vector<tuple<int, int, int>>,
		greater<tuple<int, int, int>>> pq; // cost, a, b
	isChecked[1] = 1;
	int ans = 0;
	int cnt = 0;
	for (auto nxt : adj[1]) 
		pq.push({nxt.first, 1, nxt.second});
	while (cnt < v - 1) {
		int cost, a, b;
		tie(cost, a, b) = pq.top(); pq.pop();
		if (isChecked[b]) continue;
		ans += cost;
		isChecked[b] = 1;
		++cnt;
		for (auto nxt : adj[b]) {
			if (!isChecked[nxt.second])
				pq.push({nxt.first, b, nxt.second});
		}
	}
	cout << ans << '\n';
}
