#include <iostream>
using namespace std;

int sum[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; ++i) {
		int num;
		cin >> num;
		sum[i] = sum[i - 1] + num;
	}	
	while (m--) {
		int i, j;
		cin >> i >> j;
		cout << sum[j] - sum[i - 1] << '\n';
	}
}
