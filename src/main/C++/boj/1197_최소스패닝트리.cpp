#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

int v, e;
tuple<int, int, int> edge[100'004];
vector<int> p(10'004, -1);

int find(int x) {
	if (p[x] < 0)
		return x;
	else 
		return p[x] = find(p[x]);
}

bool unionByRank(int x, int y) {
	x = find(x); y = find(y);
	if (x == y) return 0;
	if (p[x] == p[y])
		--p[x];
	if (p[x] < p[y])
		p[y] = x;
	else 
		p[x] = y;
	return 1;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

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
		if (!unionByRank(a, b))
			continue ;
		ans += cost;
		++cnt;
		if (cnt == v - 1) break;
	}
	cout << ans;
}
