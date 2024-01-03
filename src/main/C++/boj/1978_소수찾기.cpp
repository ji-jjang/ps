#include <iostream>
using namespace std;

bool isPrime(int n) {
	if (n <= 1)
		return false;
	for (int i = 2; i <= n / i; ++i) {
		if (n % i == 0)
			return false;
	}
	return true;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
	cin >> t;
	int ans = 0;
	while (t--) {
		int n;
		cin >> n;
		if (isPrime(n))
			++ans;
	}
	cout << ans;
}
