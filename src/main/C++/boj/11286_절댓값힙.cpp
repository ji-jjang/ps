#include <iostream>
#include <queue>
#include <cmath>

using namespace std;

bool compare(int a, int b) {
    if (abs(a) != abs(b))
		return abs(a) > abs(b);
	return a > b;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    priority_queue<int, vector<int>, decltype(&compare)> pq(compare);

	int n;
	cin >> n;
	while (n--) {
		int x;
		cin >> x;
		if (x == 0) {
			if (pq.empty())
				cout << "0\n";
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		} 
		else {
			pq.push(x);
		}
	}
}
