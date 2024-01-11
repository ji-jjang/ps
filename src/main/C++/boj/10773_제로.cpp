#include <iostream>
#include <stack>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int k;
	cin >> k;
	stack<int> s;
	while (k--) {
		int num;
		cin >> num;
		if (num) {
			s.push(num);
			continue;
		}
		s.pop();
	}
	int ans = 0;
	while (!s.empty()) {
		ans += s.top();
		s.pop();
	}
	cout << ans;
}
