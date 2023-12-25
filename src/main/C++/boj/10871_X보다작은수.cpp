//
// Created by ji junhyuk on 12/25/23.
//

#include <iostream>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, x;
    cin >> n >> x;

    while (n--) {
        int num;
        cin >> num;
        if (num < x) {
            cout << num << ' ';
        }
    }
}
