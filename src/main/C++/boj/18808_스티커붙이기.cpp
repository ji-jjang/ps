#include <iostream>
#include <string.h>

/*
 * 못풀었음
 */
using namespace std;

int note[41][41];
int s[11][11];
int srow, scol;

int n, m, k;

bool canAttachSticker(int y, int x) {
	if (y + srow > n || x + scol > m) 
		return false;
	for (int i = y; i < y + srow; ++i) {
		for (int j = x; j < x + scol; ++j) {
			if (s[i - y][j - x] == 1 && note[i][j] == 1)
				return false;
			if (s[i - y][j - x] == 1 && (i > n || j > m))
				return false;
		}
	}
//	cout << "붙일 수 있는 좌표, y: " << y << " x: " << x << '\n';
	return true;
}

void putSticker(int y, int x) {
	for (int i = y; i < y + srow; ++i) {
		for (int j = x; j < x + scol; ++j) {
			if (s[i - y][j - x] == 1) {
//				cout << "i: " << i << " j: " << j << '\n';
				note[i][j] = 1;
			}
		}
	}
}

void rotate(int dir) {
	while (dir-- >= 0) {
		int temp[11][11];
		for (int i = 0; i < srow; ++i) {
			for (int j = 0; j < scol; ++j) {
				temp[j][srow - i - 1] = s[i][j];
			}
		}
		swap(srow, scol);
		for (int i = 0; i < srow; ++i) {
			for (int j = 0; j < scol; ++j) {
				s[i][j] = temp[i][j];
			}
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	
	cin >> n >> m >> k;	
	for (int i = 0; i < k; ++i) {
		cin >> srow >> scol;
		for (int p = 0; p < srow; ++p) {
			for (int q = 0; q < scol; ++q) {
				cin >> s[p][q];
			}
		}
		// 가장 왼쪽 위 노트북부터 탐색하면서
		bool isAttached = false;
		for (int dir = 0; dir < 4; ++dir) {
//			cout << "현재 스티커 상태\n";
//			for (int a = 0; a < srow; ++a) {
//				for (int b = 0; b < scol; ++b) {
//					cout << s[a][b] << ' ';
//				}
//				cout << '\n';
//			}
//			cout << '\n';
			for (int a = 0; a < n; ++a) {
				if (isAttached)
					break ;
				for (int b = 0; b < m; ++b) {
					// 스티커를 붙일 수 있는지 판단한다.
					if (canAttachSticker(a, b)) {
//						cout << "스티커 붙일 수 있음\n";
						putSticker(a, b); // 스티커를 붙인다.
						isAttached = true;
						if (isAttached)
							break ;
					}
				}
			}
			if (isAttached) // 스티커가 붙여졌다면 다음 스티커 입력을 받는다.
				break ;
			rotate(dir); // dir이 0이 아닐 때 회전한다.
		}
	}
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (note[i][j] == 1)
				++ans;
		}
	}
	cout << ans << '\n';
}
	// 만약에 sticker 크기가 y + srow, x + scol보다 크지만
	// 0으로 칠해져 있는 경우 스티커를 붙일 수 있는데, 
	// 내가 작성한 코드에선 알 수 없다.
	//
// 아!

// 모든 입력을 처리하고 로직실행 vs 입력을 끊어받으며 로직처리 실행시간 비교하기
// 가장 왼쪽 위부터 스티커를 붙일 수 있는 지 탐색한다.
// 모든 자리에 스티커를 붙일 수 없다면 회전한다.
