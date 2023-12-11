#include <iostream>
#include <algorithm>

using namespace std;

int a[1001];
int N;
vector<int> two;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; ++i)
		cin >> a[i];
	sort(a, a + N);
	for (int i = 0; i < N; ++i) {
		for (int j = i; j < N; ++j)
			two.push_back(a[i] + a[j]);
	}
	sort(two.begin(), two.end());
	for (int i = N - 1; i > 0; --i) {
		for (int j = 0; j < i; ++j) {
			if (binary_search(two.begin(), two.end(), a[i] - a[j])) {
				cout << a[i];
				return 0;
			}
		}
	}
}
