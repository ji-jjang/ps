#include <iostream>
using namespace std;

int n, s;
int arr[1'000'001];
int ans = 0;

void dfs(int depth, int total) {
	if (depth == n) {
		if (total == s)
			++ans;
		return ;
	}
	dfs(depth + 1, total);
	dfs(depth + 1, total + arr[depth]);
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n >> s;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
	}	
	dfs(0, 0);
	if (s == 0)
		--ans;
	cout << ans << '\n';
}
