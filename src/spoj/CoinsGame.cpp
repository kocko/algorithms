#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

const int MAX = 1000000;
bool win[MAX + 1];

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int k, l, q;
  cin >> k >> l >> q;

  win[0] = false;
  for (int i = 1; i <= MAX; i++) {
    win[i] = !win[i - 1];
    if (i >= k && !win[i - k]) win[i] = true;
    if (i >= l && !win[i - l]) win[i] = true;
  }

  while (q--) {
    int idx;
    cin >> idx;
    cout << (win[idx] ? 'A' : 'B');
  }
}
