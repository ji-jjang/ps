#include <iostream>
using namespace std;

int dp[1004][1004];
int mod = 10'007;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, k;
	cin >> n >> k;
	for (int i = 1; i <= n; ++i) {
		dp[i][0] = dp[i][i] = 1;
		for (int j = 1; j < i; ++j) {
			dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
		}
	}
	cout << dp[n][k];
}
