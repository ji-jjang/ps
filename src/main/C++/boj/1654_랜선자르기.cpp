#include <iostream>

using namespace std;
typedef long long ll;

int lines[10'001];
int K, N;

bool solve(ll x) {
	ll cur = 0;
	for (int i = 0; i < K; ++i)
		cur += (lines[i] / x);
	return cur >= N;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> K >> N;
	for (int i = 0; i < K; ++i)
		cin >> lines[i];
	ll st = 1;
	ll en = 0x7fffffff;
	while (st < en) {
		ll mid = (st + en + 1) / 2;
		if (solve(mid))
			st = mid;
		else
			en = mid - 1;
	}
	cout << st << '\n';
}
