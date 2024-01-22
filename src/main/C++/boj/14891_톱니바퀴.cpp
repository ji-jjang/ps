#include <iostream>
using namespace std;

string wheel[7];
int rotation[7];
void rotateClockwise(int num) {
	char last = wheel[num].back();
	wheel[num].pop_back();
	wheel[num].insert(0, 1, last);
}

void rotateCounterClockwise(int num) {
	char first = wheel[num].front();
	wheel[num].erase(0, 1);
	wheel[num].push_back(first);
}

void checkRotation(int num, int direct) {
	int dir = direct;
	for (int left = num - 1; left >= 1; --left) {
		int cur = left + 1;
		if (wheel[left][2] != wheel[cur][6]) {
			dir *= -1;
			rotation[left] = dir;
		} else
			break; 
	}
	dir = direct;
	for (int right = num + 1; right <= 4; ++right) {
		int cur = right - 1;
		if (wheel[right][6] != wheel[cur][2]) {
			dir *= -1;
			rotation[right] = dir;
		} else
			break; 
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	for (int i = 1; i <= 4; ++i) cin >> wheel[i];
	int k;
	cin >> k;
	while (k--) {
		int num, dir;
		cin >> num >> dir;
		fill(rotation, rotation + 7, 0);
		rotation[num] = dir;
		checkRotation(num, dir);
		for (int i = 1; i <= 4; ++i) {
			if (rotation[i] == 0) continue;
			if (rotation[i] == 1)
				rotateClockwise(i);			
			else 
				rotateCounterClockwise(i);
		}
	}
	int score = 0;
	for (int i = 1; i <= 4; ++i) {
		if (wheel[i][0] == '1')
			score += (1 << (i - 1));
	}
	cout << score;
}

// 먼저 해당 톱니 바퀴를 회전시킨다. 
// 회전 시킨 후 왼쪽 톱니바퀴부터 본다. 현재 톱니바퀴의 6번과  왼쪽 톱니바퀴의 2번이 다르다면 왼쪽 톱니 바퀴를 회전시킨다. 왼쪽 톱니바퀴를 회전시켰다면 해당 톱니바퀴의 6번과 왼쪽 톱니 바퀴 6번을 확인한다...
// 회전 시킨 후 오른쪽 톱니바퀴를 본다. 현재 톱니 바퀴 2번과 오른쪽 톱니 바퀴 6번이 다르다면 오른쪽 톱니 바퀴를 회전시킨다. 오른쪽 톱니 바퀴를 회전시켰다면 ...
