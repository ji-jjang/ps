#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

string i2s[100'004];
unordered_map<string, int> s2i;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; ++i) {
		string name;
		cin >> name;
		i2s[i] = name;
		s2i[name] = i;	
	}
	for (int i = 1; i <= m; ++i) {
		string key;
		cin >> key;
		if (key[0] >= '0' && key[0] <= '9') {
			int num = stoi(key);
			cout << i2s[num] << '\n';
		}
		else {
			cout << s2i[key] << '\n';
		}
	}
}
