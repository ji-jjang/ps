#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
int n;
vector<ll> v;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	v.reserve(100'004);
	for (int i = 0; i < n; ++i) {
		long long num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	pair<long long, int> maxValue = {v[0], 0}; // number, cnt
	int cnt = 1;
	for (int i = 1; i < n; ++i) {
		if (v[i] == v[i - 1]) {
			++cnt;
			if (cnt > maxValue.second)
				maxValue = {v[i], cnt};
		} else
			cnt = 1;
	}
	cout << maxValue.first;
}
