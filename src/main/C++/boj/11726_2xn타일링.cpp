#include <iostream>
using namespace std;

int dp[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	
	int n; 
	cin >> n;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 3;
	for (int i = 4; i <= n; ++i)
		dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	cout << dp[n] << '\n';
}

//dp[i] 가로가 n인 타일을 채우는 경우의 수
//
// dp[1] 1개
// dp[2] 2개 
// ||
// ==
// dp[3]
// | | |
// ==  |
// | ==  3개
//
// dp[4]
//
// | | | |
// | | ==
// | ==  |
// ==  | |
// ==  ==  5개
//
//
// dp[5]
// | | | | |
// | | | ==
// | | == |
// | ==  | |
// ==  | | |
//
// | ==  ==
// == |  ==
// == == | 8개
