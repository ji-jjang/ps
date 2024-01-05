#include <iostream>
#include <queue>

using namespace std;

auto comp = [](int a, int b) { return a > b; };
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	priority_queue<int, vector<int>, decltype(comp)> pq(comp);
	while (n--) {
		int num;
		cin >> num;
		pq.push(num);
	}
	int ans = 0;
	while (pq.size() > 1) {
		int a = pq.top();
		pq.pop();
		int b = pq.top();
		pq.pop();
		ans += a + b;
		pq.push(a + b);
	}
	cout << ans << '\n';
}
