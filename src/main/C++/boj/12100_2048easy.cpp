#include <iostream>
using namespace std;

int board[21][21]; 
int backup[21][21];
int n;

void rotate(int dir) {
	if (dir == 0) 
		return;
	while (dir--) {
		int temp[21][21];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				temp[j][n - i - 1] = board[i][j];
			}
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = temp[i][j];
			}
		}
	}
}

void push(int dir) { 
	rotate(dir);
	
	for (int i = 0; i < n; ++i) {
		int tmp[21] = {};
		int idx = 0;
		for (int j = 0; j < n; ++j) {
			if (board[i][j] == 0) 
				continue ;
			if (tmp[idx] == 0) 
				tmp[idx] = board[i][j];
			else if (tmp[idx] == board[i][j])
				tmp[idx++] *= 2;
			else 
				tmp[++idx] = board[i][j];
		}
		for (int j = 0; j < n; ++j) {
			board[i][j] = tmp[j];
		}
	}
	// << 오른쪽에서 왼쪽으로 미는 push
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			cin >> backup[i][j];
		}
	}
	int ans = 0;
	int t = (1 << 2 * 5);
	for (int base = 0; base < t; ++base) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				board[i][j] = backup[i][j];
			}
		}
		int seq = base;
		for (int i = 0; i < 5; ++i) {
			int dir = seq % 4;
			push(dir);
			seq /= 4;
		}
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				ans = max(ans, board[i][j]);
			}
		}
	}
	cout << ans << '\n';
}

// 5번씩 상하좌우 이동했을 때 경우의 수 (1 << 2 * 5)
// 한쪽 방향으로 밀어주는 걸 구현
// 배열을 회전해서 다른 방향도 밀어주는 걸 구현
// dir == 0 일 때, 오른쪽에서 왼쪽으로 밀어줌.
// dir == 1 일 때, 90도 회전 후 밀어준다.
// dir == 2 180도
// dir == 3 270도

