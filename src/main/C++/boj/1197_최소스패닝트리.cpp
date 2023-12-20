#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

tuple<int, int, int> edge[100'001];
vector<int> p(10001, -1);
int v, e;

int find(int x) {
	if (p[x] < 0) return x;
	return p[x] = find(p[x]);
}

bool isDiffGroup(int u, int v) {
	u = find(u); v = find(v);
	if (u == v) return 0;
	if (p[u] == p[v]) p[u]--;
	if (p[u] < p[v]) p[v] = u;
	else p[u] = v;
	return 1;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> v >> e;
	for (int i = 0; i < e; ++i) {
		int a, b, cost;
		cin >> a >> b >> cost;
		edge[i] = {cost, a, b};
	}
	sort(edge, edge + e);
	int cnt = 0;
	int ans = 0;
	for (int i = 0; i < e; ++i) {
		int a, b, cost;
		tie(cost, a, b) = edge[i];
		if (!isDiffGroup(a, b)) continue;
		ans += cost;
		++cnt;
		if (cnt == v - 1) break;
	}
	cout << ans << '\n';
}
