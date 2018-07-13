#include <bits/stdc++.h>
using namespace std;

#define endl '\n'

typedef long long hyper;

const int MAXN = 2005;
string x, y;
int n, m, k, dp[MAXN][MAXN];

hyper recurse(int i, int j) {
  if (i == n) return k * (m - j);
  if (j == m) return k * (n - i);
  if (dp[i][j] != -1) return dp[i][j];
  
  hyper ans = abs(x[i] - y[j]) + recurse(i + 1, j + 1);
  ans = min(ans, k + recurse(i + 1, j));
  ans = min(ans, k + recurse(i, j + 1));
  
  return dp[i][j] = ans;
}

int main() {
  memset(dp, -1, sizeof dp);
  cin >> x >> y;
  cin >> k;
  n = x.length();
  m = y.length();
  cout << recurse(0, 0) << endl;
  return 0;
}
