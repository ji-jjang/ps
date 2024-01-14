#include <iostream>
using namespace std;

int a[1'000'004];
int tmp[1'000'004];

void merge(int st, int en) {
	int mid = (st + en) / 2;
	int l = st, r = mid;
	for (int i = st; i < en; ++i) {
		if (l == mid)
			tmp[i] = a[r++];
		else if (r == en)
			tmp[i] = a[l++];
		else if (a[l] < a[r])
			tmp[i] = a[l++];
		else
			tmp[i] = a[r++];
	}
	for (int i = st; i < en; ++i)
		a[i] = tmp[i];
}

void mergeSort(int st, int en) {
	if (en - st <= 1)
		return ;
	int mid = (st + en) / 2;
	mergeSort(st, mid);
	mergeSort(mid, en);
	merge(st, en);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	mergeSort(0, n);
	for (int i = 0; i < n; ++i)
		cout << a[i] << ' ';
}
