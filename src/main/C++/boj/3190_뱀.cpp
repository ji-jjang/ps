#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int board[104][104];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, k, l;
	cin >> n >> k;
	for (int i = 0; i < k; ++i) {
		int y, x;
		cin >> y >> x;
		board[y - 1][x - 1] = 2;
	}
	cin >> l;
	queue<pair<int, char>> rot;
	for (int i = 0; i < l; ++i) {
		int time; char dir;
		cin >> time >> dir;
		rot.push({time, dir});
	}
	tuple<int, int, int> head = {0, 0, 1};
	board[0][0] = 1;
	queue<pair<int, int>> body;
	body.push({0, 0});
	int time = 0;
	while (1) {
		++time;
		auto [y, x, dir] = head;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny < 0 || ny >= n || nx < 0 || nx >= n)
			break;
		if (board[ny][nx] == 1)
			break;
		if (board[ny][nx] != 2) {
			auto [tailY, tailX] = body.front(); body.pop();
			board[tailY][tailX] = 0;
		}
		board[ny][nx] = 1;
		body.push({ny, nx});
		head = {ny, nx, dir};
		if (!rot.empty() && time == rot.front().first) {
			if (rot.front().second == 'D')
				dir = (dir + 1) % 4;
			else
				dir = (dir + 3) % 4;
			head = {ny, nx, dir};
			rot.pop();
		}
	}
	cout << time;
}
