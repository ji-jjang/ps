#include <iostream>
using namespace std;

int n, k;
int coin[11];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		cin >> coin[i];
	}
	int ans = 0;
	for (int i = n - 1; i >= 0; --i) {
		if (coin[i] <= k) {
			ans += k / coin[i];
			k %= coin[i];
		}
	}
	cout << ans;
}
