#include <iostream>
using namespace std;

int gcd(int a, int b) {
	if (a == 0)
		return b;
	return gcd(b % a, a);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
	cin >> t;
	int m, n, x, y;
	while (t--) {
		cin >> m >> n >> x >> y;
		int lcm = m / gcd(m, n) * n;
		bool isFind = false;
		if (x == m) x = 0;
		if (y == n) y = 0;
		for (int i = x; i <= lcm; i += m) {
			if (i == 0)
				continue ;
			if (i % n == y) {
				isFind = true;
				cout << i << '\n';
				break;
			}
		}
		if (!isFind)
			cout << -1 << '\n';
	}
}
