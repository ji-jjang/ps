#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    vector<pair<int, int>> flowers;
    for (int i = 0; i < n; ++i) {
        int sm, sd, em, ed;
        cin >> sm >> sd >> em >> ed;
        flowers.push_back({sm * 100 + sd, em * 100 + ed});
    }
    sort(flowers.begin(), flowers.end());
    int st = 301;
    int idx = 0;
    int ans = 0;
    while (st < 1201) {
        int liveDays = 0;
        while (idx < n && flowers[idx].first <= st) {
            liveDays = max(liveDays, flowers[idx].second);
            idx++;
        }
        if (liveDays == 0) {
			ans = 0;
			break;
        }
        st = liveDays;
		++ans;
    }
    cout << ans;
}

