#include <iostream>

using namespace std;

typedef long long hyper;

const int MOD = (int) 1e9 + 7, MAX = 24;
int n, k;

hyper dp[1 << MAX], a[1 << MAX];
int bad[2] = {-1, -1};

int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[1 << i];
  cin >> k;
  for (int i = 0; i < k; i++) cin >> bad[i];
  for (int i = 1; i < (1 << n); i++) {
    int bit = i & -i;
    a[i] = a[i - bit] + a[bit];
    a[i] %= MOD;
  }
  
  dp[0] = 1;
  for (int mask = 1; mask < (1 << n); mask++) {
    if (a[mask] == bad[0] || a[mask] == bad[1]) continue;
    hyper value = 0;
    for (int i = 0; i < n; i++) {
      if (mask & (1 << i)) {
        value += dp[mask ^ (1 << i)];
      }
    }
    dp[mask] = value % MOD;
  }
  cout << dp[(1 << n) - 1];
  return 0;
}
