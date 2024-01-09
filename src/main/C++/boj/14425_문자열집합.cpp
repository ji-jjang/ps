#include <iostream>
using namespace std;

const int ROOT = 1;
int unused = 2;
const int MX = 10000 * 500 + 4;
bool chk[MX];
int nxt[MX][26];

void insert(string& s) {
	int cur = ROOT;
	for (auto c : s) {
		if (nxt[cur][c - 'a'] == -1)
			nxt[cur][c - 'a'] = unused++;
		cur = nxt[cur][c - 'a'];
	}
	chk[cur] = true;
}

bool find(string& s) {
	int cur = ROOT;
	for (auto c : s) {
		if (nxt[cur][c - 'a'] == -1)
			return false;
		cur = nxt[cur][c - 'a'];
	}
	return chk[cur];
}

int n, m;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	for (int i = 0; i < MX; ++i)
		fill(nxt[i], nxt[i] + 26, -1);
	cin >> n >> m;
	while (n--) {
		string s;
		cin >> s;
		insert(s);
	}
	int ans = 0;
	while (m--) {
		string s;
		cin >> s;
		ans += find(s);
	}
	cout << ans;
}
