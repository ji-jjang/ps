#include <iostream>
#include <stdio.h>
using namespace std;

int step[305];
int dp[305][305];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> step[i];
	}
	dp[1][1] = step[1];
	dp[1][2] = 0;
	dp[2][1] = step[2];
	dp[2][2] = step[1] + step[2];
	int ans = 0;
	for (int i = 3; i <= n; ++i) {
		dp[i][1] = max(dp[i - 2][2], dp[i - 2][1]) + step[i];
		dp[i][2] = dp[i - 1][1] + step[i];
	}
	cout << max(dp[n][1], dp[n][2]); 
}

//dp[i][j] : i계단을 밟았을 때 연속해서 밟은 계단의 갯수
//dp[1][1] = 1계단을 밟았을 때 연속해서 밟은 계단이 1개
		// 이전계단을 안밟았음
//dp[1][2] = 1계단을 밟았을 때 연속해서 밟은 계단이 2개
		// 이전계단과 현재 계단을 밟았음
//dp[2][1] = dp[2 - 2][2], dp[2 - 2][1] + step[i]
//
//dp[2][2] = // dp[2 - 3][2], dp[2-3][1] + dp[2 - 1][1] + step[i]
