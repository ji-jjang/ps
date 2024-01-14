#include <iostream>
using namespace std;

int a[1'000'004];
int b[1'000'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; ++i) cin >> a[i];
	for (int i = 0; i < m; ++i) cin >> b[i];
	int l = 0;
	int r = 0;
	for (int i = 0; i < n + m; ++i) {
		if (l == n)
			cout << b[r++] << ' ';
		else if (r == m)
			cout << a[l++] << ' ';
		else if (a[l] > b[r])
			cout << b[r++] << ' ';
		else
			cout << a[l++] << ' ';
	}
}
