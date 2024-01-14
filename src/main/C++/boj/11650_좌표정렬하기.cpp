#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	vector<pair<int, int>> v;
	v.reserve(100'000);
	for (int i = 0; i < n; ++i) {
		int x, y;
		cin >> x >> y;
		v.push_back({x, y});
	}
	sort(v.begin(), v.end(), [](auto& a, auto& b){
			if (a.first == b.first)
				return a.second < b.second;
			return a.first < b.first;
	});
	for (auto& e : v) 
		cout << e.first << ' ' << e.second << '\n';
}
