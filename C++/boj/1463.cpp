#include <iostream>
using namespace std;

int dp[1'000'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	dp[1] = 0;
	for (int i = 2; i <= N; ++i) {
		dp[i] = dp[i - 1] + 1;
		if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1);
		if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
	}
	cout << dp[N] << '\n';
}
// 1. 테이블 정의하기
// 	-> dp[i] = i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값
// 2. 점화식 찾기
// 3. 초기값 정의하기	
