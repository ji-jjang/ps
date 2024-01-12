#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	queue<int> q;
	for (int i = 1; i <= n; ++i)
		q.push(i);
	while (q.size() > 1) {
		q.pop();
		int top = q.front();
		q.pop();
		q.push(top);
	}
	cout << q.front();
}
