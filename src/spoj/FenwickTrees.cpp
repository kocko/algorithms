#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;


const int MAX = 1000000;
hyper tree[MAX + 1];

void update(int idx, hyper delta) {
  for (; idx <= MAX; idx += (idx & -idx)) tree[idx] += delta;
}

hyper f(int idx) {
  hyper result = 0;
  for (; idx > 0; idx -= (idx & -idx)) result += tree[idx];
  return result;
}

hyper query(int left, int right) {
  return f(right) - f(left - 1);
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, value, q;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> value;
    update(i, value);
  }
  char type;
  cin >> q;
  while (q--) {
    cin >> type;
    if (type == 'u') {
      int a; hyper b;
      cin >> a >> b;
      update(a, b);
    } else {
      int left, right;
      cin >> left >> right;
      cout << query(left, right) << endl;
    }
  }
  return 0;
}
