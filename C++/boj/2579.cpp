#include <iostream>
#include <algorithm>
using namespace std;

int dp[301][3];
int step[301];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> step[i];
	}
	dp[1][1] = step[1], dp[1][2] = 0;
	dp[2][1] = step[2], dp[2][2] = step[1] + step[2];
	for (int i = 3; i <= N; ++i) {
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + step[i];
		dp[i][2] = dp[i - 1][1] + step[i];
	}
	cout << max(dp[N][1], dp[N][2]) << '\n';
}
// 1. 테이블 정의하기
// dp[i][j] = 현재까지 j개의 계단을 연속해서 밟고 i번째 계단까지 올라섰을 때 점수 합의 최댓값, 단 i번째 계단은 반드시 밟아야함(짬에서 나오는 바이브)
// 
// 2. 점화식 세우기
// dp[N][1] = max(dp[N - 2][1] + dp[N - 2][2]) + now[N]
// dp[N][2] = dp[N - 1][1] + now[N]
//
// 3. 초기값
// dp[1][1] = now[1], dp[1][2] = 0;
// dp[2][1] = now[2], dp[2][2] = now[1] + now[2] 
//
//
// ===========
// 1. 테이블 정의하기
// dp[i] = i 번째 계단 까지 올라섰을 때 밟지 않을 계단의 합의 최솟값, 단 i번째 계단은 반드시 밟지 않을 계단으로 선택해야함.
//
// 2. 점화식 세우기
// dp[i] = dp[i - 1] 밟아야함. dp[i - 2] 밟을 수 있음. dp[i - 3] 밟을 수 있음.
//
// dp[N] = min(dp[N -2], dp[N - 3]) + now[N];
//
