#include <iostream>
using namespace std;

int coins[11];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int N, K;

	cin >> N >> K;
	for (int i = 0; i < N; ++i) {
		cin >> coins[i];
	}
	long ans = 0;
	for (int i = N - 1; i >= 0; --i) {
		ans += (K / coins[i]);
		K %= coins[i];
	}	
	cout << ans << '\n';
}
