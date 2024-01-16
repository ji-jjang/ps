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
	for (int i = 0; i < n * n; ++i) {
		int num;
		cin >> num;
		pq.push(num);
		if ((int)pq.size() > n)
			pq.pop();
	}
	cout << pq.top() << '\n';
}
