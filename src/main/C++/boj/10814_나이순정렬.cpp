#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	vector<pair<int, string>> v;
	v.reserve(100'000);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		int age;
		string name;
		cin >> age >> name;
		v.push_back({age, name});
	}
	stable_sort(v.begin(), v.end(), [](auto& a, auto &b) {
			return a.first < b.first;
	});
	for (int i = 0; i < n; ++i)
		cout << v[i].first << ' ' << v[i].second << '\n';
}
