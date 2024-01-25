#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int a[14];
int oper[4];
int n;
int mx = -1e9;
int mn = 1e9;
void dfs(int depth, int sum) {
	if (depth == n) {
		mx = max(mx, sum);
		mn = min(mn, sum);
	}
	for (int i = 0; i < 4; ++i) {
		if (oper[i] == 0)
			continue;
		oper[i]--;
		if (i == 0)
			dfs(depth + 1, sum + a[depth]);
		else if (i == 1)
			dfs(depth + 1, sum - a[depth]);
		else if (i == 2)
			dfs(depth + 1, sum * a[depth]);
		else
			dfs(depth + 1, sum / a[depth]);
		oper[i]++;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];
	for (int i = 0 ; i < 4; ++i) {
		cin >> oper[i];
	}
	dfs(1, a[0]);
	cout << mx << '\n' << mn;
}
