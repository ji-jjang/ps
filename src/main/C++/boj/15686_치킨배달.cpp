#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> house;
vector<pair<int, int>> chick;
int n, m;
int ans = 1e9;
void dfs(int depth, int start, vector<pair<int, int>>& seq, vector<bool>& isVisited) {
	if (depth == m) {
		int sum = 0;
		for (auto h : house) {
			int minChickDist = 1e9;
			for (auto c : seq)
				minChickDist = min(minChickDist, abs(c.first - h.first) + abs(c.second - h.second));
			sum += minChickDist;	
		}
		ans = min(ans, sum);
		return; 
	}
	for (int i = start; i < (int)chick.size(); ++i) {
		if (isVisited[i])
			continue;
		isVisited[i] = true;
		seq.push_back(chick[i]);
		dfs(depth + 1, i + 1,  seq, isVisited);
		isVisited[i] = false;
		seq.pop_back();
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			int num; 
			cin >> num;
			if (num == 1)
				house.push_back({i, j});
			else if (num == 2)
				chick.push_back({i, j});
		}
	}
	vector<pair<int, int>> seq;
	vector<bool> isVisited(chick.size(), false);
	dfs(0, 0, seq, isVisited);
	cout << ans;
}
