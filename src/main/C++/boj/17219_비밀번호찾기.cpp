#include <iostream>
#include <unordered_map>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	unordered_map<string, string> map;
	int n, m;
	cin >> n >> m;
	while (n--) {
		string site, pw;
		cin >> site >> pw;
		map[site] = pw;
	}
	while (m--) {
		string site;
		cin >> site;
		cout << map[site] << '\n';
	}
}
