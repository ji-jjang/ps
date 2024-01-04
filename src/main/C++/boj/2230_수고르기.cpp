#include <iostream>
#include <algorithm>
using namespace std;

int a[100'004];
int n, m;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> m;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	sort(a, a + n);
	int ans = 0x7fffffff;
	int st = 0;
	int en = 0;
	while (en < n) {
		int diff = a[en] - a[st];
		if (diff >= m) {
			ans = min(ans, a[en] - a[st]);
			++st;
		} else {
			++en;
		}
	}
	cout << ans;
}

//	for (int i = 0; i < n; ++i) {
//		int find = lower_bound(a, a + n, a[i] + m) - a;
//		if (find < n)
//			ans = min(ans, a[find] - a[i]);
//		else
//			break;
//	}
//	cout << ans;
