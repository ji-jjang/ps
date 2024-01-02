#include <iostream>
#include <algorithm>
using namespace std;
pair<int, int> meetings[100'004];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) 
		cin >> meetings[i].first >> meetings[i].second;
	sort(meetings, meetings + n, [](const pair<int, int> &a, const pair<int, int> &b) {
			if (a.second == b.second) 
				return (a.first < b.first);
			return a.second < b.second;
	});
	int end = 0;
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		if (end <= meetings[i].first) {
			++ans;
			end = meetings[i].second;
		}
	}
	cout << ans;	
}

//	cout << '\n';
//	for (int i = 0; i< n; ++i) {
//		cout << meetings[i].first << ' ' << meetings[i].second << '\n';
//	}
//	cout << '\n';
// 회의를 끝나는 순으로 오름차순 정렬하고, 
// 끝나는 시간이 같다면, 회의 시간이 짧은 걸 선택
// 끝나는 시간이 같다면, 시작 시간이 빠른 걸 선택 // 1, 4를 선택하고 4 4를 선택할 수 있어야 한다.
