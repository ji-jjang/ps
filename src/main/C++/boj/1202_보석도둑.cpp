#include <iostream>
#include <set>
#include <algorithm>

using namespace std;

pair<int, int> jewel[300'001];
multiset<int> bag;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int N, K;
	cin >> N >> K;
	for (int i = 0; i < N; ++i) 
		cin >> jewel[i].first >> jewel[i].second;
	sort(jewel, jewel + N, [](const auto& a, const auto& b) {
			return a.second < b.second;
	});
	for (int i = 0; i < K; ++i) {
		int c;
		cin >> c;
		bag.insert(c);
	}
	long long ans = 0;
	for (int i = N - 1; i >= 0; --i) {
		int m, v;
		tie(m, v) = jewel[i];
		auto it = bag.lower_bound(m);
		if (it == bag.end())
			continue ;
		ans += v;
		bag.erase(it);
	}
	cout << ans << '\n';
}
