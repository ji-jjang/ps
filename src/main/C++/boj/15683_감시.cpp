#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

int room[9][9];
int tmpRoom[9][9];
vector<tuple<int, int, int>> cctv;
int r, c;
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void checkPath(int y, int x, int dir) {
	while (1) {
		y += dy[dir];
		x += dx[dir];
		if (y < 0 || y >= r || x < 0 || x >= c)
			break;
		if (tmpRoom[y][x] == 6)
			break;
		if (1 <= tmpRoom[y][x] && tmpRoom[y][x] <= 5) {
			continue;
		}
		tmpRoom[y][x] = 9;
	}
}

void watchCCTV(int dir, int idx) {
	auto cur = cctv[idx];
	int y = get<0>(cur);
	int x = get<1>(cur);
	int cctvNum = get<2>(cur);
	if (cctvNum == 1) {
		checkPath(y, x, dir);
	} else if (cctvNum == 2) {
		checkPath(y, x, dir);
		checkPath(y, x, (dir + 2) % 4);
	} else if (cctvNum == 3) {
		checkPath(y, x, dir);
		checkPath(y, x, (dir + 1) % 4);
	} else if (cctvNum == 4) {
		checkPath(y, x, dir);
		checkPath(y, x, (dir + 1) % 4);
		checkPath(y, x, (dir + 3) % 4);
	} else if (cctvNum == 5) {
		checkPath(y, x, dir);
		checkPath(y, x, (dir + 1) % 4);
		checkPath(y, x, (dir + 2) % 4);
		checkPath(y, x, (dir + 3) % 4);
	}
} 


int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cin >> r >> c;
	for (int i = 0; i < r; ++i) {
		for (int j = 0; j < c; ++j) {
			cin >> room[i][j];
			if (1 <= room[i][j] && room[i][j] <= 5)
				cctv.push_back({i, j, room[i][j]});
		}
	}
	int ans = 0x7fffffff;
	for (int base = 0; base < (1 << 2 * cctv.size()); ++base) {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				tmpRoom[i][j] = room[i][j];
			}
		}
		int tmp = base;
		int idx = 0;
		for (int mod = 0; mod < cctv.size(); ++mod) {
			int cur = tmp % 4;
			watchCCTV(cur, idx); // dir, turn
			tmp /= 4;
			++idx;
		}

		int blindArea = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (tmpRoom[i][j] == 0)
					++blindArea;
			}
		}
		ans = min(ans, blindArea);
	}
	cout << ans << '\n';
}
// CCTV가 탐색할 수 있는 방향 4방향
// CCTV 1 -> 4
// CCTV 2 -> 4 * 4
// CCTV 3 -> 4 * 4 * 4
// 1 << 2 * n
//
//	int n = 4; 
//	for (int i = 0; i < n; ++i) {
//		int seq = i;
//		for (int i = 0; i < 4; ++i) {
//			cout << seq % 4 << ' ';
//			seq /= 4;
//		}
//		cout << '\n';
//	}
// cctv 번호와 cctv가 감시하는 방향이 주어진다.
// dir=0일 북, dir=1 서..
// 1번cctv일 경우 현재 dir 대로 검사하면 됨
// 2번cctv:(dir), (dir + 2) % 4;
// 3번cctv:(dir), (dir + 1) % 4;
// 4번cctv:(dir), (dir + 1) % 4, (dir + 3) % 4;
// 5번cctv:(dir), (dir + 1) % 4 + ... (dir + 3) % 4;
