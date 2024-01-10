#include <iostream>
#include <unordered_map>
using namespace std;

int main(void) { 
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int t;
	cin >> t;

	while (t--) {
		int n;
		cin >> n;
		unordered_map<string, int> m;
		for (int i = 0; i < n; ++i) {
			string cName, cType;
			cin >> cName >> cType;
			m[cType]++;
		}
		int ans = 1;
		for (auto e : m)
			ans *= e.second + 1;
		cout << ans - 1 << '\n';
	}	
}
// 특정 키에 대한 값을 처음 접근하면, 그 키에 해당하는 값은 기본 생성자를 사용하여 초기화됩니다. 이는 기본 자료형에 대해서도 동일하게 적용되므로, int 타입의 경우 0으로 초기화됩니다.
// 전체 타입이 몇 개 인지, 어떤 타입이 몇 개 있는지 알면 된다
//
// 조합할 수 있는 경우의 수2 * 1
// 한가지만 쓸수 있는 경우의 수: 기본적으로 모자의 개수 + 안경의 개수
	
