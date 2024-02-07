#include <iostream>
using namespace std;

int dp[44][2];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin >> t;
	dp[0][0] = 1;
	dp[1][1] = 1;
	for (int i = 2; i <= 40; ++i) {
		dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
		dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
	}
	while (t--) {
		int n; 
		cin >> n;
		cout << dp[n][0] << ' '<< dp[n][1] << '\n';
	}
}
// dp[i][0] i를 호출했을 때 0이 호출되는 횟수
// dp[i][1] i를 호출했을 때 1이 호출되는 횟수
//	dp[2][0] = 1;  // fibo(1) fibo(0)
//	dp[2][0] = 1;  // fibo(1) fibo(0)
//				   //
//	dp[3][0] = 1 + 0;	
