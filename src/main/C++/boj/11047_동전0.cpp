#include <iostream>
using namespace std;

int c[14];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; ++i)
		cin >> c[i];
	int ans = 0;
	for (int i = n - 1; i >= 0; --i) {
		ans += k / c[i];
		k %= c[i];
	}
	cout << ans;
}
