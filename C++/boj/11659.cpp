#include <iostream>
using namespace std;

int arr[100'001], dp[100'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	for (int i = 1; i <= N; ++i) {
		cin >> arr[i];
		dp[i] = dp[i - 1] + arr[i];
	}
	while (M--) {
		int st, en;
		cin >> st >> en;
		cout << dp[en] - dp[st - 1] << '\n';
	}	
}
