#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int k, l;
	unordered_map<string, int> m;
	cin >> k >> l;
	int idx = 1;
	for (int i = 1; i <= l; ++i) {
		string id;
		cin >> id;
		m[id] = i;
	}
	vector<pair<string, int>> v(m.begin(), m.end());
	sort(v.begin(), v.end(), [](auto& a, auto& b) {
			return a.second < b.second;
	});
	int count = 0;
	for (auto e : v) {
		cout << e.first << '\n';
		++count;
		if (count == k) break; 
	}
}
