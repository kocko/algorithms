#include <bits/stdc++.h>

using namespace std;

string s;
int i;

int rec() {
    if (s[i] == 'l') {
        return 1;
    } else {
        i++;
        int l = 1 + rec();
        i++;
        int r = 1 + rec();
        return max(l, r);
    }
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        cin >> s;
        i = 0;
        cout << rec() - 1 << '\n';
    }
}