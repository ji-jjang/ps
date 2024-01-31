#include <iostream>
#include <algorithm>
using namespace std;

pair<int, int> meets[100'004]; // start, end
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> meets[i].first >> meets[i].second;
	sort(meets, meets + n, [](auto& a, auto& b) {
			if (a.second == b.second)
				return a.first < b.first;
			return a.second < b.second;
	});
	int now = 0;
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		if (now <= meets[i].first) {
			now = meets[i].second;
			++ans;
		}
	}
	cout << ans;
}
