#include <iostream>
using namespace std;

int dp[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	dp[1] = 1;
	dp[2] = 3;
	dp[3] = 5;
	for (int i = 3; i <= 1000; ++i)
		dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10'007;
	cout << dp[n];
}
// dp[i]: 가로의 너비가 i일 때 채울 수 있는 타일의 개수
// dp[1] = 1;
// dp[2] = 3;
// dp[3] = 5; 
// 		   | ㅁ 
//         ㅁ|
//         |||
//         ㅡ|
//         | ㅡ
// dp[4] = 11
//			||||
//			|ㅁ|
//			||ㅁ
//			ㅁ||
//			|ㅡ|
//			||ㅡ
//			ㅡ||
//			ㅁㅁ
//			ㅡㅡ
//
//			ㅁㅡ
//			ㅡㅁ
//
//
// dp[1] = 1;
// dp[2] = 2;
// dp[3] = 3;
// dp[4] = 5;
// dp[5] = 8;
// ||||
// || ㅡ
// |ㅡ|
// ㅡ||
// ㅡㅡ
