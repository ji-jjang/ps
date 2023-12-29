#include <string>
#include <iostream>
#include <stack>
using namespace std;

int main(void) {

	while (true) {
		string line;
		getline(cin, line);
		stack<char> S;
		bool isValid = true;
		if (line == ".")
			break ;
		for (auto c : line) {
			if (c == '(' || c == '[') {
				S.push(c);
			}
			if (c == ')' || c == ']') {
				if (c == ')') {
					if (S.empty() || S.top() != '(') {
						isValid = false;
						break ;
					}
					S.pop();
				}
				if (c == ']') {
					if (S.empty() || S.top() != '[') {
						isValid = false;
						break ;
					}
					S.pop();
				}
			}
		}
		if (!S.empty())
			isValid = false;
		if (isValid) {
			cout << "yes\n";
		} else {
			cout << "no\n";
		}
	}
}
