#include <iostream>
#include <unordered_map>
using namespace std;

unordered_map<string, int> s2i;
string i2s[100'001];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	for (int i = 1; i <= N; i++) {
		cin >> i2s[i];
		s2i[i2s[i]] = i;
	}
	while (M--) {
		string query;
		cin >> query;
		if (isdigit(query[0]))
			cout << i2s[stoi(query)] << '\n';
		else
			cout << s2i[query] << '\n';
	}
}
