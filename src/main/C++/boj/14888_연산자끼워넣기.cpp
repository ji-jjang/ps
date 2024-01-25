#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int a[14];
vector<int> oper;
int n;
int mx = -1e9;
int mn = 1e9;
void dfs(int depth, vector<int>& seq, vector<bool> isSelected) {
	if (depth == n - 1) {
		int result = a[0];
		for (int i = 1; i < n; ++i) {
			if (seq[i - 1] == 0) {
				result += a[i];
			} else if (seq[i - 1] == 1) {
				result -= a[i];
			} else if (seq[i - 1] == 2) {
				result *= a[i];
			} else if (seq[i - 1] == 3) {
				result /= a[i];
			}
		}
		mx = max(mx, result);
		mn = min(mn, result);
	}
	int prev = -1;
	for (int i = 0; i < (int)oper.size(); ++i) {
		if (isSelected[i] || (prev != -1 && oper[i] == oper[prev]))
			continue;
		isSelected[i] = true;
		seq.push_back(oper[i]);
		dfs(depth + 1, seq, isSelected);
		seq.pop_back();
		isSelected[i] = false;
		prev = i;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	for (int i = 0 ; i < 4; ++i) {
		int cnt;
		cin >> cnt;
		for (int j = 0; j < cnt; ++j)
			oper.push_back(i);
	}
	vector<int> seq;
	vector<bool> isSelected(oper.size(), false);
	dfs(0, seq, isSelected);
	cout << mx << '\n' << mn;
}
