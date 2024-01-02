#include <iostream>
using namespace std;

int dp[1'000'001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	dp[0] = 0;
	dp[1] = 0;
	for (int i = 2; i <= n; ++i) {
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0)
			dp[i] = min(dp[i], dp[i / 2] + 1);
		if (i % 3 == 0)
			dp[i] = min(dp[i], dp[i / 3] + 1);
	}
	cout << dp[n];

}
// dp[i] = 1로 만들기 위한 연산의 최소값
// dp[1] = 0;
// dp[2] = min(dp[2 - 1], if (i % 2 ==) dp[2 / 2]);
// dp[3] = min(dp[3 - 1], if (i % 3 ==) dp[3 / 3]);
