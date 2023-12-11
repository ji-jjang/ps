#include <iostream>
#include <algorithm>
using namespace std;

int Sang[500'001];
int N, M;

int lower_idx(int target) {
	int st = 0;
	int en = N;
	while (st < en) {
		int mid = (st + en) / 2;
		if (Sang[mid] >= target)
			en = mid;
		else 
			st = mid + 1;
	}
	return st;
}

int upper_idx(int target) {
	int st = 0;
	int en = N;
	while (st < en) {
		int mid = (st + en) / 2;
		if (Sang[mid] > target)
			en = mid;
		else
			st = mid + 1;
	}
	return st;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; ++i)
		cin >> Sang[i];
	sort(Sang, Sang + N);
	cin >> M;
	for (int i = 0; i < M; ++i) {
		int num;
		cin >> num;
		cout << upper_idx(num) - lower_idx(num) << ' ';
	}

}
