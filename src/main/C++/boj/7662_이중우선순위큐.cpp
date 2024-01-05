#include <iostream>
#include <set>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) {
		int k;
		cin >> k;
		multiset<int> ms;
		while (k--) {
			char op;
			cin >> op;
			if (op == 'I') {
				int num; 
				cin >> num;
				ms.insert(num);
			} else if (op == 'D') {
				int num;
				cin >> num;
				if (ms.empty())
					continue ;
				if (num == 1) {
					ms.erase(prev(ms.end()));
				} else {
					ms.erase(ms.begin());
				}
			}
		}
		if (ms.empty())
			cout << "EMPTY\n";
		else
			cout << *prev(ms.end()) << ' ' << *ms.begin() << '\n';
	}
}
