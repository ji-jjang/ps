#include <iostream>
using namespace std;

int n;
int counting[2'000'002];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	
	cin >> n;
	for (int i = 0; i < n; ++i) {
		int num; 
		cin >> num;
		counting[num + 1'000'000]++;
	}
	for (int i = 0; i <= 2'000'000; ++i) {
		while (counting[i]--)
			cout << i - 1'000'000 << '\n';
	}
}
