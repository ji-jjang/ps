#include <iostream>
#include <queue>
using namespace std;

int n;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	auto comp = [](auto& a, auto& b) { return a > b; };
	priority_queue<int, vector<int>, decltype(comp)> pq(comp);
	cin >> n;
	while (n--) {
		int num;
		cin >> num;
		if (!num) {
			if (pq.empty())
				cout << 0 << '\n';
			else {
				cout << pq.top() << '\n';
				pq.pop();
			}
		} else
			pq.push(num);
	}
}
