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
		pq.push(num);
	}	
	int cnt = 0;
	while (pq.size() > 1) {
		int a = pq.top();
		pq.pop();
		int b = pq.top();
		pq.pop();
		cnt += (a + b);
		pq.push(a + b);
	}
	cout << cnt;
}
