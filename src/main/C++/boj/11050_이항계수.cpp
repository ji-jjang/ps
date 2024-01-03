#include <iostream>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, k;
	cin >> n >> k;

	int result = 1;
	for (int i = 1; i <= n; ++i) {
		result *= i;
	}
	for (int i = 1; i <= k; ++i) {
		result /= i;
	}
	for (int i = 1; i <= (n - k); ++i) {
		result /= i;
	}
	cout << result << '\n';
}
