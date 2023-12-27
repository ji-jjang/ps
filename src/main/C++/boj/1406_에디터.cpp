#include <iostream>
#include <list>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string init;
	cin >> init;
	list<char> l;
	for (auto c : init)
		l.push_back(c);
	auto cursor = l.end();
	int n; 
	cin >> n;
	while (n--) {
		char op;
		cin >> op;
		if (op == 'L') {
			if (cursor != l.begin())
				--cursor;
		} else if (op == 'D') {
			if (cursor != l.end()) {
				++cursor;
			}
		} else if (op == 'B') {
			if (cursor != l.begin()) {
				--cursor;
				cursor = l.erase(cursor);
			}
		} else {
			char ch;
			cin >> ch;
			l.insert(cursor, ch);
		}
	}
	for (auto c : l) {
		cout << c;
	}
}
