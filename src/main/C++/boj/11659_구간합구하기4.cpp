#include <iostream>
using namespace std;

int sum[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
	cin >> n >> m;
	cin >> sum[1];
	for (int i = 2; i <= n; ++i) {
		int num;
		cin >> num;
		sum[i] = sum[i - 1] + num;
	}
	while (m--) {
		int st, en;
		cin >> st >> en; 
		cout << sum[en] - sum[st - 1] << '\n';
	}
}
