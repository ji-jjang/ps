#include <iostream>
using namespace std;

bool col[40];
bool diag1[50];
bool diag2[50];

int n;
int ans;
void recur(int row) {
	if (row == n) {
		++ans;
		return ;
	}
	for (int i = 0; i < n; ++i) {
		if (col[i] || diag1[i + row] || diag2[row - i + n - 1]) 
			continue ;
		col[i] = true;
		diag1[i + row] = true;
		diag2[row - i + n - 1] = true;
		recur(row + 1);
		col[i] = false;
		diag1[i + row] = false;
		diag2[row - i + n - 1] = false;
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> n;
	recur(0);
	cout << ans << '\n';
}
