#include <iostream>
#include <algorithm>
using namespace std;

int A[101], B[101];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> A[i];
	}
	for (int i = 0; i < N; ++i) {
		cin >> B[i];
	}
	sort(A, A + N);
	sort(B, B + N);
	long ans = 0;
	for (int i = 0; i < N; ++i) {
		ans += (A[i] * B[N - i - 1]);
	}
	cout << ans << '\n';
}
