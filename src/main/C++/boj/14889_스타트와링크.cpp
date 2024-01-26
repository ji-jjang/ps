#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int synergy[24][24];
int ans = 1e9;
void dfs(int depth, int start, vector<bool>& isSelected) {
	if (depth == n / 2) {
		int sumA = 0; int sumB = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = i + 1; j <= n; ++j) {
				if (isSelected[i] && isSelected[j])
					sumA += synergy[i][j] + synergy[j][i];
				else if (!isSelected[i] && !isSelected[j])
					sumB += synergy[i][j] + synergy[j][i];
			}
		}
		ans = min(ans, abs(sumA - sumB));
		return ;
	}
	for (int i = start; i <= n; ++i) {
		isSelected[i] = true;
		dfs(depth + 1, i + 1, isSelected);
		isSelected[i] = false;
	}
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j)
			cin >> synergy[i][j];
	}
	vector<bool> isSelected(n, false);
	dfs(0, 1, isSelected);
	cout << ans;
}
