#include <iostream>
#include <algorithm>
using namespace std;

int a[54], b[54];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
	for (int i = 0; i < n; ++i) {
		cin >> b[i];
	}
	sort(a, a + n);
	sort(b, b + n, [](int a, int b) {
			return a > b;
	});
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		ans += a[i] * b[i];	
	}
	cout << ans;
}
