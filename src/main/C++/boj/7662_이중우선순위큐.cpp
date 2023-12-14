#include <iostream>
#include <set>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	while (T--) {
		int k;
		cin >> k;
		multiset<int> ms;
		while (k--) {
			char op;
			cin >> op;
			if (op == 'D') {
				int pri;
				cin >> pri;
				if (ms.empty())
					continue ;
				if (pri == 1)
					ms.erase(prev(ms.end()));
				else
					ms.erase(ms.begin());
			} else {
				int pri;
				cin >> pri;
				ms.insert(pri);
			}
		}
		if (ms.empty()) 
			cout << "EMPTY\n";
		else
			cout << *prev(ms.end()) << ' ' << *ms.begin() << '\n';
	}
}
