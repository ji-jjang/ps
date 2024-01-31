#include <iostream>
#include <algorithm>
using namespace std;

int r[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> r[i];
	sort(r, r + n);
	int mx = r[n - 1];
	for (int i = 0; i < n; ++i)
		mx = max(mx, r[i] * (n - i);
	cout << mx;
}
