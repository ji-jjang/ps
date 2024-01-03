#include <iostream>
#include <algorithm>
using namespace std;

int a[1004];
vector<int> two;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	sort(a, a + n);
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			two.push_back({a[i] + a[j]});
		}
	}
	sort(two.begin(), two.end());
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (binary_search(two.begin(), two.end(), a[i] - a[j])) {
				ans = max(ans, a[i]);
			}
		}
	}
	cout << ans;
}
