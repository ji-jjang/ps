#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>
using namespace std;

int n, c;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> c;
	unordered_map<int, pair<int, int>> map; // 위치 + 반복한 횟수
	for (int i = 0; i < n; ++i) {
		int num;
		cin >> num;
		if (map[num].second == 0)
			map[num].first = i;
		(map[num].second)++;
	}
	vector<pair<int, pair<int, int>>> v;
	for (auto& e : map)
		v.push_back(e);
	sort(v.begin(), v.end(), [](auto& a, auto& b){ 
			if (a.second.second != b.second.second)
				return a.second.second > b.second.second;
			return a.second.first < b.second.first;
	});
	for (auto& e : v) {
		for (int i = 0; i < e.second.second; ++i)
			cout << e.first << ' ';
	}
}
