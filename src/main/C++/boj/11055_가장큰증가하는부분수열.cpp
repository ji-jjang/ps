#include <iostream>
#include <algorithm>
using namespace std;

int dp[1004];
int nums[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> nums[i];
		dp[i] = nums[i];
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j < i; ++j) {
			if (nums[j] < nums[i])
				dp[i] = max(dp[i], dp[j] + nums[i]);
		}
	}
	cout << *max_element(dp + 1, dp + n + 1);
}
// dp[i] i를 마지막으로 하는 증가하는 부분수열 
// dp[1] = 1
// dp[2] = 101
// dp[3] = 3
// dp[4] = 53
// dp[5] = 113
// dp[6] = 6
// dp[7] = 11
// dp[8] = 17
// dp[9] = 24
// dp[10] = 32
// dp[i] i까지 증가하는 부분 수열의  합
