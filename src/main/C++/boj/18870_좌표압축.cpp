#include <iostream>
#include <algorithm>
using namespace std;

int a[1'000'004];
int tmp[1'000'004];
int b[1'000'004];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
		tmp[i] = a[i];
	}
	sort(tmp, tmp + n);
	int idx = 0;
	b[idx++] = tmp[0];
	for (int i = 1; i < n; ++i) {
		if (tmp[i] == tmp[i - 1])
			continue ;
		b[idx++] = tmp[i];
	}
	for (int i = 0; i < n; ++i) {
		cout << lower_bound(b, b + idx, a[i]) - b << ' ';
	}
}
