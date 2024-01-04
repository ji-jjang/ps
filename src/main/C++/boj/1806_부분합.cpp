#include <iostream>
using namespace std;

int a[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, s;

	cin >> n >> s;
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
	int st = 0;
	int en = 0;
	int ans = 0x7fffffff;
	int sum = 0;
	while (en <= n) {
		if (sum >= s) {
			sum -= a[st];
			++st;
			ans = min(ans, en - st + 1);
		}
		else {
			sum += a[en];
			++en;
		}
	}
	if (ans == 0x7fffffff) 
		cout << 0;
	else
		cout << ans;
}
