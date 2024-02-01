#include <iostream>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	string s;
	cin >> s;
	int sign = 1;
	string num = "";
	int ans = 0;
	for (auto c : s) {
		if (c == '-' || c == '+') {
			ans += sign * stoi(num);
			num.clear();
			if (c == '-')
				sign = -1;
			continue; 
		}
		num += c;
	}
	ans += sign * stoi(num);
	cout << ans;
}
