#include <iostream>
using namespace std;

int dp[1'000'004];
int path[1'000'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	dp[1] = 0;
	path[1] = 1;
	for (int i = 2; i <= n; ++i) {
		dp[i] = dp[i - 1] + 1;
		path[i] = i - 1;
		if (i % 2 == 0 && dp[i] > (dp[i / 2] + 1)) {
			dp[i] = dp[i / 2] + 1;
			path[i] = i / 2;
		}
		if (i % 3 == 0 && dp[i] > (dp[i / 3] + 1)) {
			dp[i] = dp[i / 3] + 1;
			path[i] = i / 3;
		}
	}
	int now = n;
	cout << dp[n] << '\n';
	if (n != 1)
		cout << n << ' ';
	while (path[now] != 1) {
		cout << path[now] << ' ';
		now = path[now];
	}
	cout << 1;
}
