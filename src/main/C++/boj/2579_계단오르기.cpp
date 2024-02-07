#include <iostream>
#include <algorithm>
using namespace std;

int score[304];
int dp[304][3];
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i)
		cin >> score[i];
	dp[1][1] = score[1];
	dp[1][2] = 0; 
	dp[2][1] = score[2];
	dp[2][2] = score[1] + score[2];
	for (int i = 3; i <= n; ++i) {
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + score[i];
		dp[i][2] = dp[i - 1][1] + score[i];
	}
	cout << max(dp[n][1], dp[n][2]);
}

// dp[i] : i번째 계단에 오르기까지 최대 점수
// 한번에 한 계단, 두 계단씩 오를 수 있으므로 dp[i]만으론 해결할 수 없다.
// 
// dp[i][1] i번 계단을 1칸 밟아 오른 경우 :	// 여기에서 dp[i - 2][1]를 고려할 필요가 있을까? 없다. dp[i - 2][1]을 밟았다면, dp[i - 1][1]을 밟을 수 있고, dp[i][2]를 밟을 수 있다. 즉 과거 사건이 현재시점에 영향을 준다. 이러면 계산이 정확하지 않을 수 있다. 현재 시점을 고정해놓고 과거를 판단해야 한다. 현재 시점을 가지고 정확하게 판단할 수 있는 시점은 dp[i - 2][2]까지
	// 잘못된 점화식을 구함.  max(dp[i - 1][1], dp[i - 2][2]); 
	// dp[i - 1][1]을 해버리면 i - 1번째까지 1칸 밟아 오른 경우를 더하는 것. dp[i]는 매 순간 dp[i - 1]을 호출할 수 있으니 예상과 다르게 계단을 3개 이상 연속하여 오를 수 있게된다.

// dp[i][2] i번 계단을 2칸 밟아 오른 경우 : dp[i - 1][1] + score[i];
// 잘못된 점화식을 구함.
// dp[i][2]를 구하기 위해서 과거 정보 dp[i - 2]로 구하는데, 이는 현 시점을 반영할 수 있는 값이 아님. dp[i][2]는 단순히 dp[i - 1][1] + score[i] 로 구할 수 있 이전계단은 당연히 못밟지
//
