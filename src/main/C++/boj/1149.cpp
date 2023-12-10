#include <iostream>
#include <algorithm>
using namespace std;

int dp[1001][3];
int r[1001], g[1001], b[1001];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> r[i] >> g[i] >> b[i];
	}
	dp[1][0] = r[1], dp[1][1] = g[1], dp[1][2] = b[1];
	for (int i = 2; i <= N; ++i) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + r[i];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + g[i];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + b[i];
	}
	cout << min({dp[N][0], dp[N][1], dp[N][2]}) << '\n';
}
// 1. 테이블 정의하기
// dp[i][3] -> dp[i][0]에는 빨강으로 시작했을 경우를 담아
// 
// 2. 점화식 찾기
// dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + R[i];
// dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + G[i];
// dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + B[i];
//
// 3. 초기값
// dp[1][0] = R, dp[1][1] = G, dp[1][2] = B
