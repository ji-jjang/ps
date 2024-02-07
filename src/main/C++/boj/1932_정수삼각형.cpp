#include <iostream>
#include <algorithm>
using namespace std;

int dp[504][504];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);	
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= i; ++j) {
			int num;
			cin >> num;
			dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + num;		
		}
	}
	cout << *max_element(dp[n], dp[n] + n + 1);
}

//	int ans = 0;
//	for (int i = 1; i <= n; ++i)
//		ans = max(ans, dp[n][i]);
//	cout << ans;
//	cout << '\n';
//	cout << '\n';
//	for (int i = 1; i <= n; ++i) {
//		for (int j = 1; j <= i; ++j) {
//			cout << dp[i][j] << ' ';
//		}
//		cout << '\n';
//	}
// dp[i][0] 첫번째 줄에서 왼쪽 선택
// dp[i][1] 두번째 줄에서 오른쪽 선택
// 크기가 5인 삼각형
// dp[i][0] // i번째 0을 선택했을 때 최댓값
//
// dp[i][1], dp[i][2], dp[i][3], dp[i][0], dp[i][5]중 최대값
//
//			dp[i][0] = num[i][0];
//			dp[i][1] = max(num[i][0], num[i][1]);
//			dp[i][2] = max(num[i][1], num[i][2]);
//			dp[i][3] = max(num[i][2], num[i][3]);
//			dp[i][4] = max(num[i][3], num[i][4]);
//			cout << num[i][j] << ' ';	
