#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int a[100'004];

int binarySearch(int st, int en, int target) {
	while (st <= en) {
		int mid = (st + en) / 2;
		if (a[mid] < target) {			
			st = mid + 1;
		} else if (a[mid] > target) {
			en = mid - 1;
		} else
			return 1;
	}
	return 0;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}
	sort(a, a + n);
	cin >> m;
	while (m--) {
		int target;
		cin >> target;
		cout << binarySearch(0, n - 1, target) << '\n';
	}
}
