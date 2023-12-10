#include <iostream>
using namespace std;

int dp[1001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;

	cin >> N;
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= N; ++i) {
		dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	}
	cout << dp[N] << '\n';
}
// 1. 테이블 정의하기
// dp[i] = 2 * i 크기의 직사각형을 채우는 방법의 수
//
// 2. 점화식
// dp[i] = dp[i - 1] + dp[i - 2];
//
// 3. 초기값 
// dp[1] = 1; dp[2] = 2;
