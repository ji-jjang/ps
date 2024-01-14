#include <iostream>
#include <unordered_set>
#include <algorithm>
using namespace std;

int n;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	unordered_set<string> s;
	while (n--) {
		string word;
		cin >> word;
		s.insert(word);
	}
	vector<string> v(s.begin(), s.end());
	sort(v.begin(), v.end(), [](auto& a, auto& b) {
			if (a.length() != b.length())
				return a.length() < b.length();
			return a < b;
	});
	for (auto e : v)
		cout << e << '\n';
}
