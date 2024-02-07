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
	for (int i = 3; i <= n; ++i) {
		dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	}
	cout << dp[n];
}
// dp[i] // 너비가 i인 직사각형을 타일로 채우는 개수
// dp[1] = 1;
// dp[2] = 2;
// dp[3] = 3;
// dp[4] = 5;
// 			| | | |
//          |  ㅡ |
//          ||  ㅡ 
//          ㅡ  | |
//           ㅡ ㅡ 
