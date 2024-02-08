#include <iostream>
#include <algorithm>
using namespace std;

int t[19];
int p[19];
int dp[19]; 
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
