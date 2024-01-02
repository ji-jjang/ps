#include <iostream>
#include <algorithm>
using namespace std;

int rope[100'003];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> rope[i];
	sort(rope, rope + n);
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		ans = max(ans, rope[i] * (n - i));
	}
	cout << ans;
}
