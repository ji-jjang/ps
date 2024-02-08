#include <iostream>
using namespace std;

int t[1'500'004];
int p[1'500'004];
int dp[1'500'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i)
		cin >> t[i] >> p[i];
	for (int i = 1; i <= n; ++i) {
		dp[i] = max(dp[i], dp[i - 1]);
		if (i + t[i] <= n + 1)
			dp[i + t[i]] = max(dp[i + t[i]], dp[i] + p[i]);
	}
	cout << max(dp[n], dp[n + 1]);
}
