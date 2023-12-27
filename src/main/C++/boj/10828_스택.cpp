#include <iostream>
#include <stack>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	stack<int> S;

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		string op;
		cin >> op;
		if (op == "push") {
			int x;
			cin >> x;
			S.push(x);
		} else if (op == "pop") {
			if (S.empty()) cout << -1 << '\n';
			else {
				cout << S.top() << '\n';
				S.pop();
			}
		} else if (op == "size") {
			cout << S.size() << '\n';
		} else if (op == "empty") {
			if (S.empty()) {
				cout << 1 << '\n';
			} else
				cout << 0 << '\n';
		} else {
			if (S.empty()) {
				cout << -1 << '\n';
			} else
				cout << S.top() << '\n';
		}
	}
}
