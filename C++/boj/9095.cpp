#include <iostream>
using namespace std;

int dp[1'000'001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	dp[1] = 1, dp[2] = 2, dp[3] = 4;
	for (int i = 4; i <= 11; ++i)
		dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
	int T;
	cin >> T;
	while (T--) {
		int num; 
		cin >> num;
		cout << dp[num] << '\n';
	}
}
// 1. 테이블 정의하기
// dp[i] = i를 1,2,3의 합으로 나타내는 수
// 
// 2. 점화식 찾기
// 1 + 1 + 1 + 1, 3 + 1, 2 + 1 + 1, 1 + 2 + 1
// 1 + 1 + 2, 2 + 2
// 1 + 3
// dp[4] = dp[1] + dp[2] + dp[3]
//
// 3. 초기값
// dp[1] = 1; dp[2] = 3; dp[3] = 4;
