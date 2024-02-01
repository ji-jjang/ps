#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

int prices[1'000'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		long long ans = 0;
		for (int i = 0; i < n; ++i)
			cin >> prices[i];
		int mx = prices[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			int now = prices[i];
			if (mx < now)
				mx = now;
			ans += mx - now;
		}
		cout << ans << '\n';
	}
}

