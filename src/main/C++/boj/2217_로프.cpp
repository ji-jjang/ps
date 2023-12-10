#include <iostream>
using namespace std;

int rope[100'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	for (int i = 0; i < N; ++i) 
		cin >> rope[i];
	sort(rope, rope + N);
	int ans = 0;
	for (int i = 1; i <= N; ++i)
		ans = max(ans, rope[N - i] * i);
	cout << ans << '\n';
}
