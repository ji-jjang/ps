#include <iostream>
#include <stack>
using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	stack<int> s;
	string ans = "";
    int n;
	cin >> n;
	int maxNum = 0;
	while (n--) {
		int num; 
		cin >> num;
		for (int i = maxNum + 1; i <= num; ++i) {
			s.push(i);	
			ans += "+\n";
		}
		maxNum = max(maxNum, num);
		if (!s.empty() && s.top() != num) {
            cout << "NO";
			return 0;
		}
		s.pop();
		ans += "-\n";
	}
    cout << ans;
}
