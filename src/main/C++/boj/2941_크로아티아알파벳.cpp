#include <iostream>
#include <vector>
using namespace std;

vector<string> croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string s;
	cin >> s;
	for (auto c : croa) {
		while (true) {
			int pos = s.find(c);
			if (pos == string::npos) break;
			s.replace(pos, c.size(), "!");
		}
	}
	cout << s.size();
}
