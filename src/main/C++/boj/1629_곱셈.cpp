#include <iostream>
using namespace std;
typedef long long ll;

ll recur(ll a, ll b, ll c) {
	if (b == 1) {
		return a % c;
	}
	ll val = recur(a, b / 2, c);
	val = val * val % c;
	if (b % 2 == 0)
		return val;
	return val * a % c;

}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	ll a, b, c;
	cin >> a >> b >> c;
	cout << recur(a, b, c) << '\n';
}
