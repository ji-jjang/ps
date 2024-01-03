#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
int a[500'004];

int lowerBound(int target) {
	int st = 0;
	int en = n;

	while (st < en) {
		int mid = (st + en) / 2;
		if (a[mid] < target)
			st = mid + 1;
		else 
			en = mid;
	}
	return st;
}

int upperBound(int target) {
	int st = 0;
	int en = n;

	while (st < en) {
		int mid = (st + en) / 2;
		if (a[mid] <= target)
			st = mid + 1;
		else 
			en = mid;
	}
	return st;
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
	for (int i = 0; i < m; ++i) {
		int target;
		cin >> target;
		cout << upperBound(target) - lowerBound(target) << ' ';
	}
}
