#include <iostream>
using namespace std;

int dp[14];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	dp[1] = 1; dp[2] = 2; dp[3] = 4;
	for (int i = 4; i <= 10; ++i)
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		cout << dp[n] << '\n';
	}
}
// dp[i] = i를 만드는 데 필요한 갯수
// dp[1] = 1
// dp[2] = 2
// dp[3] = 4
