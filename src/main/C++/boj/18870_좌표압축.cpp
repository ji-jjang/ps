#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int numbers[1'000'001];
vector<int> uni, tmp;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;	
	for (int i = 0; i < N; ++i) {
		cin >> numbers[i];
		tmp.push_back(numbers[i]);
	}
	sort(tmp.begin(), tmp.end());
	int idx = 0;
	for (int i = 0; i < N; ++i) {
		if (i == 0 || tmp[i] != tmp[i - 1])
			uni.push_back(tmp[i]);
	}
	for (int i = 0; i < N; ++i)
		cout << lower_bound(uni.begin(), uni.end(), numbers[i]) - uni.begin() << ' ';
}
