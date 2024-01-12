#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	queue<int> q;
	while (n--) {
		string cmd;
		cin >> cmd;
		if (cmd == "push") {
			int num;
			cin >> num;
			q.push(num);
		} else if (cmd == "pop") {
			if (q.empty()) {
				cout << -1 << '\n';
				continue;
			}
			cout << q.front() << '\n';
			q.pop();
		} else if (cmd == "size") {
			cout << q.size() << '\n';
		} else if (cmd == "empty") {
			if (q.empty()) {
				cout << 1 << '\n';
				continue;
			}
			cout << 0 << '\n';
		} else if (cmd == "front") {
			if (q.empty()) {
				cout << -1 << '\n';
				continue;
			}
			cout << q.front() << '\n';
		} else if (cmd == "back") {
			if (q.empty()) {
				cout << -1 << '\n';
				continue;
			}
			cout << q.back() << '\n';
		}
	}
}
