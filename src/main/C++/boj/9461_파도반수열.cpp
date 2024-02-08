#include <iostream>
#include <deque>
typedef long long ll;
using namespace std;

ll dp[104];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 1;
	dp[4] = 2;
	dp[5] = 2;
	dp[6] = 3;
	deque<ll> seq = {1, 1, 2, 2, 3, 3};
	for (int i = 7; i <= 100; ++i) {
		ll now = seq.front() + seq.back();
		dp[i] = now;
		seq.pop_front();
		seq.pop_back();
		seq.push_back(now);
		seq.push_back(now);
	}
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		cout << dp[n] << '\n';
	}
}
//dp[i] : 변의 길이가 i인 삼각형의 개수
//
//d[1] = 3;
//d[2] = 2;
//d[3] = 1;
//d[4] = 
//
//
//dp[i]: i번째 삼각형의 변의 길이
//
//
//
//dequeue<int> gen; gen.push(1, 1, 2, 2, 3, 3);
//
//for (int i = 7; i <= 100; ++i) {
//	dp[i] = (앞에서 뺀거 + 뒤에서 뺀거) 이거 2개 넣어
//}
//
//
//
//
