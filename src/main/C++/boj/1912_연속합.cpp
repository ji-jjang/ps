#include <iostream>
#include <algorithm>
using namespace std;

int dp[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		int num;
		cin >> num;
		dp[i] = max(dp[i - 1] + num, num);
	}
	cout << *max_element(dp + 1, dp + n + 1);
}

// dp[i]: i까지 더한 부분합 + i와 i 중  더 큰 수 저장
// i까지 더한 부분합 + i가 0보다 작다면 0으로
