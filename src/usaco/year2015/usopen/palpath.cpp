#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

const int MAX_N = 500;
const long long MOD = (long) 1e9 + 7;

int first[2][2]  = {{-1, 0}, {0, -1}};
int second[2][2] = {{ 1, 0}, {0,  1}};

int n;
string grid[MAX_N];
long long dp[MAX_N][MAX_N][MAX_N];

void input() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> grid[i];
  }
  memset(dp, -1, sizeof(dp));
}

long long recurse(int r1, int c1, int r2) {
  if (r1 == 0 && c1 == 0 && r2 == n - 1) return grid[0][0] == grid[n - 1][n - 1] ? 1 : 0;

  if (dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

  int moves = n - (r1 + c1) - 1;
  int c2 = moves - r2 + n - 1;
  long ans = 0;
  for (auto d1 : first) {
    for (auto d2 : second) {
      int x1 = r1 + d1[0], y1 = c1 + d1[1];
      int x2 = r2 + d2[0], y2 = c2 + d2[1];
      if (x1 >= 0 && x1 < n &&
          y1 >= 0 && y1 < n &&
          x2 >= 0 && x2 < n &&
          y2 >= 0 && y2 < n &&
          grid[x1][y1] == grid[x2][y2]) {
        ans += recurse(x1, y1, x2);
        ans %= MOD;
      }
    }
  }
  return dp[r1][c1][r2] = ans;
}

void solve() {
  long long ans = 0;
  for (int r1 = 0; r1 < n; r1++) {
    ans += recurse(r1, n - r1 - 1, r1);
    ans %= MOD;
  }
  cout << ans << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	freopen("palpath.in", "r", stdin);
	freopen("palpath.out", "w", stdout);
	input();
	solve();
}
