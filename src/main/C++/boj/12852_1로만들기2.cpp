#include <iostream>
using namespace std;

int dp[1'000'001];
int pre[1'000'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	dp[1] = 0;
	for (int i = 2; i <= N; ++i) {
		dp[i] = dp[i - 1] + 1;
		pre[i] = i - 1;
		if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
		   	dp[i] = dp[i / 2] + 1;
			pre[i] = i / 2;
		}
		if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
		   	dp[i] = dp[i / 3] + 1;
			pre[i] = i / 3;
		}
	}
	cout << dp[N] << '\n';
	int now = N;
	while (true) {
		cout << now << ' ';
		if (now == 1)
			break;
		now = pre[now];
	}
}
