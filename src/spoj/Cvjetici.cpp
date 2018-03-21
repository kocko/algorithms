#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

const int MAX = 100000;

int tree[MAX + 1];
int flowers[MAX + 1];

void update(int idx, int delta) {
  for (; idx <= MAX; idx += (idx & -idx)) {
    tree[idx] += delta;
  }
}

int query(int idx) {
  int result = 0;
  for (; idx > 0; idx -= (idx & -idx)) {
    result += tree[idx];
  }
  return result;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  cin >> n;
  while (n--) {
    int left, right, a, b;
    cin >> left >> right;
    a = query(left), b = query(right);
    cout << a - flowers[left] + b - flowers[right] << endl;
    flowers[left] = a, flowers[right] = b;
    update(left + 1, 1);
    update(right, -1);
  }
  return 0;
}
