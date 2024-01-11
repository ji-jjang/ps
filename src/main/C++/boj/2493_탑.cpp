#include <iostream>
#include <stack>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	stack<pair<int, int>> s;
	pair<int, int> dummy = {0x7fffffff, 0};
	s.push(dummy);
	for (int i = 1; i <= n; ++i) {
		int h;
		cin >> h;
		while (s.top().first < h)
			s.pop();
		cout << s.top().second << ' ';
		s.push({h, i});
	}
}
