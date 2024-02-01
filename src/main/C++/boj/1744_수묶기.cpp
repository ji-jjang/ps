#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> pos;
vector<int> neg;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	int zero = 0;
	int one = 0;
	for (int i = 0; i < n; ++i) {
		int num;
		cin >> num;
		if (num < 0)
			neg.push_back(num);
		else if (num == 0)
			++zero;	
		else if (num == 1)
			++one;
		else 
			pos.push_back(num);
	}
	sort(neg.begin(), neg.end(), [](auto& a, auto &b) { return  a > b; });
	sort(pos.begin(), pos.end());
	int ans = 0;
	while (neg.size() > 1) {
		ans += *(neg.end() - 1) * *(neg.end() - 2);
		neg.pop_back();
		neg.pop_back();
	}
	if (neg.size()) {
		if (zero == 0)
			ans += neg[0];
	}
	while (pos.size() > 1) {
		ans += *(pos.end() - 1) * *(pos.end() - 2);
		pos.pop_back();
		pos.pop_back();
	}
	if (pos.size()) 
		ans += pos[0];
	ans += one;
	cout << ans;
}
