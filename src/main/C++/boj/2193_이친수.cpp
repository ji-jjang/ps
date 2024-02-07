#include <iostream>
using namespace std;

long long dp[94];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	dp[1] = 1;
	dp[2] = 1;
	for (int i = 3; i <= 90; ++i)
		dp[i] = dp[i - 2] + dp[i - 1];
	cout << dp[n];
}
//dp[i]: i자리 이친수의 개수
//
//dp[1] = 1개;
//dp[2] = 1개;
//dp[3] = 101, 100 2개
//dp[4] = 1010, 1001, 1000 3개
//dp[5] = 10100, 10101, 10010, 10001, 10000 5개
//
// 이전에 1로 끝났던 것들은 반드시 뒤에 0이 붙어야 하고(1개 추가), 이전에 0으로 끝났던 것은 뒤에 0과 1(2개 추가) 붙을 수 있다.
// dp[i][k]: i자리수 중 k로 끝나는 이친수의 개수. k는 0또는 1
// dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
// dp[i][1] = dp[i - 1][0];
//
// dp[i] = dp[i - 2] + dp[i - 1];
