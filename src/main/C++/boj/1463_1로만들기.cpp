#include <iostream>
#include <algorithm>
using namespace std;

int dp[1'000'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	dp[0] = 0; dp[1] = 0;
	for (int i = 2; i <= n; ++i) {
		dp[i] = dp[i - 1] + 1;
		if (i % 3 == 0)
			dp[i] = min(dp[i], dp[i / 3] + 1);
		if (i % 2 == 0)
			dp[i] = min(dp[i], dp[i / 2] + 1);
	}
	cout << dp[n];
}

// dp[i] : i를 1로 만드는데 필요한 횟수
// dp[i] 
// dp[1] = 0;
// dp[2] = dp[i - 1] + 1;
// dp[3] = min(dp[i - 1], dp[i / 2], dp[i / 3]) + 1;
