#include <iostream>
using namespace std;

int a[10'000'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 2; i <= n; ++i)
		a[i] = i;
	for (int i = 2; i <= n / i; ++i) {
		if (a[i] == 0)
			continue ;
		for (int j = i + i; j <= n; j += i)
			a[j] = 0;
	}
	for (int i = 2; i <= n / i; ++i) {
		if (a[i] == 0)
			continue ;
		while (n % a[i] == 0) {
			cout << i << '\n';
			n /= a[i];
		}
	}
	if (n != 1)
		cout << n;
}
