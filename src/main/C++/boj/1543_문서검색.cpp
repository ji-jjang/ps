#include <iostream>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string stack; 
	string needle;

	getline(cin, stack);
	getline(cin, needle);

	int ans = 0;
	int pos = stack.find(needle, pos);
	while (pos != -1) {
		++ans;
		pos = stack.find(needle, pos + needle.size());
	}
	cout << ans;
}
