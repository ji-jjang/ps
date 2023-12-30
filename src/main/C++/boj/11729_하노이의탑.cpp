#include <iostream>
using namespace std;

void hanoi(int n, int a, int c) {
	if (n == 1) {
		cout << a << ' ' << c << '\n';
		return ;
	}
	hanoi(n - 1, a, 6 - a - c);
	cout << a << ' ' << c << '\n';
	hanoi(n - 1, 6 - a - c, c);
}
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	cout << (1 << n) - 1 << '\n';
	hanoi(n, 1, 3);
}
