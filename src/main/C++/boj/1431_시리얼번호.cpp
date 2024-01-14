#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int findSum(string& s) {
	int result = 0;
	for (auto& c : s) {
		if (c >= '0' && c <= '9')
			result += c - '0';
	}
	return result;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	vector<string> v;
	for (int i = 0; i < n; ++i) {
		string num;
		cin >> num;
		v.push_back(num);	
	}
	sort(v.begin(), v.end(), [](auto &a, auto &b) {
			if (a.length() != b.length())
				return a.length() < b.length();
			int sumA = findSum(a);
			int sumB = findSum(b);
			if (sumA != sumB)
				return sumA < sumB;
			return a < b;
	});
	for (auto e : v)
		cout << e << '\n';
}
