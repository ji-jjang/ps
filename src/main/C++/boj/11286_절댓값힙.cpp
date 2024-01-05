#include <iostream>
#include <queue>
#include <vector>
using namespace std;

auto comp = [](int a, int b) {
	if (abs(a) != abs(b))
		return abs(a) > abs(b);
	return a > b;
};

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    priority_queue<int, vector<int>, decltype(comp)> pq(comp);

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

// 기본적으로 최대힙, 비교함수를 역으로 작성해야 한다.
