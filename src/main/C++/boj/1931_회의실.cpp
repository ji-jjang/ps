#include <iostream>
using namespace std;

pair<int, int> meetings[100'001]; // start, end;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int N;
	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> meetings[i].first >> meetings[i].second;
	}	
	sort(meetings, meetings + N, [](const pair<int, int>& a, const pair<int, int>& b) {
			if (a.second != b.second)
				return a.second < b.second;
			return a.first < b.first;
    });
	for (int i = 0; i < N; ++i) {
		cout << meetings[i].first << ' ' << meetings[i].second << '\n';
	}
	int end = -1;
	long ans = 0;
	for (int i = 0; i < N; ++i) {
		if (end <= meetings[i].first) {
			end = meetings[i].second;
			++ans;
		}
	}
	cout << ans << '\n';
}
// 회의 시간 시작 시간을 기준으로 정렬해.
// 일찍 끝나는 걸 기준으로 정렬해
