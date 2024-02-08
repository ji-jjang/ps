#include <iostream>
#include <algorithm>
using namespace std;

int nums[1004];
int dp[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> nums[i];
		dp[i] = 1;
	}
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j < i; ++j) {
			if (nums[j] < nums[i])
				dp[i] = max(dp[i], dp[j] + 1);
		}
	}
	cout << *max_element(dp + 1, dp + 1 + n);
}
