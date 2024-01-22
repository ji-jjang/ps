#include <iostream>
#include <queue>
using namespace std;

int n, w, l;
int trucks[1004];
int bridge[1004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> w >> l;
	queue<int> q;
	for (int i = 0; i < n; ++i) {
		int weight;
		cin >> weight;
		q.push(weight);
	}
	int time = 0;
	while (!q.empty()) {
		auto cur = q.front(); 
		// moveCar
		for (int i = w; i >= 1; --i) 
			bridge[i] = bridge[i - 1];
		bridge[0] = 0;
		int curWeight = 0;
		for (int i = 0; i < w; ++i)
			curWeight += bridge[i];
		// putCar
		++time;
		if (curWeight + cur <= l) {
			bridge[0] = cur;
			curWeight -= cur;
			q.pop();
		} 
	}
	cout << time + w << '\n';
}
