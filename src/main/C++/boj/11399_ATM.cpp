#include <iostream>
#include <algorithm>
using namespace std;

int t[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> t[i];
	sort(t, t + n);
	int ans = 0;
	for (int i = 0; i < n; ++i)
		ans += t[i] * (n - i);
	cout << ans;
}
