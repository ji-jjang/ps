#include <iostream>
using namespace std;

int dp[11];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
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
// dp[i] = i를 만들기 위한 수의 합
//
// num : 1 -> 1
// 1
//
// num : 2 -> 2
//
// 1 1
// 2
//
// num : 3 -> 4
// 1 1 1
// 1 2
// 2 1
// 3
//
// num : 4 -> 7
// 1 1 1 1
// 1 1 2
// 1 3
// 1 2 1
// 2 1 1
// 2 2
// 3 1
