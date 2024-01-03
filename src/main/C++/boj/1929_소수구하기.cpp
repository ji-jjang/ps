#include <iostream>
using namespace std;

int a[1'000'003];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int m, n;
	cin >> m >> n;
	for (int i = 2; i <= n; ++i) 
		a[i] = i;
	for (int i = 2; i <= n / i; ++i) {
		if (a[i] == 0)
			continue ;
		for (int j = i + i; j <= n; j = j + i)
			a[j] = 0;
	}
	for (int i = m; i <= n; ++i) {
		if (a[i] != 0)
			cout << a[i] << '\n';
	}
}

