#include <iostream>
#include <algorithm>
using namespace std;

int dp[1004][3];
int h[1004][3];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < 3; ++j) 
			cin >> h[i][j];
	}
	dp[0][0] = h[0][0];
	dp[0][1] = h[0][1];
	dp[0][2] = h[0][2];
	for (int i = 1; i < n; ++i) {
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + h[i][0];
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + h[i][1];
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + h[i][2];
	}
	cout << min({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
}

// dp[i][0] i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 빨강
