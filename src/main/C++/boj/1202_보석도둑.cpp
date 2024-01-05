#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

int n, k;
pair<int, int> jewels[300'004];
multiset<int> bag;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		cin >> jewels[i].first >> jewels[i].second;
	}
	sort(jewels, jewels + n, [](const auto& a, const auto& b) {
		return a.second < b.second;
	});
	for (int i = 0; i < k; ++i) {
		int num;
		cin >> num;
		bag.insert(num);
	}
	long long ans = 0;
	for (int i = n - 1; i >= 0; --i) {
		int m, v;
		tie(m, v) = jewels[i];
		auto find = bag.lower_bound(m);
		if (find == bag.end())
			continue;
		ans += v;
		bag.erase(find);
	}
	cout << ans;
}
