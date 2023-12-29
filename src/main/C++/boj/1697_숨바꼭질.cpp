#include <iostream>
#include <queue>
using namespace std;
int n, k;
bool isVisited[200'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> k;

	queue<pair<int, int>> Q; 
	isVisited[n] = true;
	Q.push({n, 0});
	while (!Q.empty()) {
		auto cur = Q.front();
		Q.pop();
		int loc = cur.first;
		int time = cur.second;
		if (loc == k) {
			cout << time << '\n';
			return 0;
		}
		if (loc <= 100'000 && !isVisited[loc + 1]) {
			isVisited[loc + 1] = true;
			Q.push({loc + 1, time + 1});
		}
		if (loc >= 1 && loc <= 100'000 && !isVisited[loc - 1]) {
			isVisited[loc - 1] = true;
			Q.push({loc - 1, time + 1});
		}
		if (loc <= 100'000 && !isVisited[loc * 2]) {
			isVisited[loc * 2] = true;
			Q.push({loc * 2, time + 1});
		}
	}
}
