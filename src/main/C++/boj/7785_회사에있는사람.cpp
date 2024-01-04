#include <iostream>
#include <unordered_set>
#include <vector>
#include <algorithm>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	unordered_set<string> s;
	for (int i = 0; i < n; ++i) {
		string name, log;
		cin >> name >> log;
		
		if (log == "enter") {
			s.insert(name);
		} else
			s.erase(name);
	}
	vector<string> v(s.begin(), s.end());
	sort(v.begin(), v.end(), [](const string &a, const string &b) {
			return a > b;
	});
	for (auto c : v)
		cout << c << '\n';
}
