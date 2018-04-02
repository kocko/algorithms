#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

const int MAX = 100000, oo = (int) 1e9;

int lo[4 * MAX + 1], hi[4 * MAX + 1], result[4 * MAX + 1];
int x[MAX + 1];

void init(int idx, int a, int b) {
  lo[idx] = a;
  hi[idx] = b;
  if (a == b) {
    result[idx] = x[a];
    return;
  }
  int mid = (a + b) >> 1;
  init(2 * idx, a, mid);
  init(2 * idx + 1, mid + 1, b);

  result[idx] = min(result[2 * idx], result[2 * idx + 1]);
}

int query(int idx, int a, int b) {
  if (b < lo[idx] || a > hi[idx]) return oo;
  if (a <= lo[idx] && b >= hi[idx]) return result[idx];

  int left = query(2 * idx, a, b), right = query(2 * idx + 1, a, b);
  return min(left, right);
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  for (int testCase = 1; testCase <= t; testCase++) {
    int n, q;
    cin >> n >> q;
    for (int i = 0; i < n; i++) {
      cin >> x[i];
    }
    init(1, 0, n - 1);
    cout << "Scenario #" << testCase << ":" << endl;
    while (q-- > 0) {
      int left, right;
      cin >> left >> right;
      cout << query(1, left - 1, right - 1) << endl;
    }
  }
  return 0;
}
