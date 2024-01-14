#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
typedef long long ll;

int n;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	vector<ll> nums;
	nums.reserve(1'000'000);
	for (int i = 0; i < n; ++i) {
		string num; cin >> num;
		reverse(num.begin(), num.end());
		size_t idx = num.find_first_not_of('0');
		num.erase(0, idx);
		nums.push_back(stoll(num));
	}
	sort(nums.begin(), nums.end(), [](auto& a, auto& b) {
		return a < b;	
	});
	for (auto e : nums)
		cout << e << '\n';
}
