#include <bits/stdc++.h>

using namespace std;

#define endl '\n'

typedef long long hyper;

const int MAX_M = 2005;

double dp[MAX_M + 1], current[MAX_M + 1];

double expectedValue(int blond, int black) {
  for (int i = 1; i <= blond; i++) {
    for (int j = 0; j <= black; j++) {
      long double prob = (long double) i / (i + j);
      current[j] = prob * (1 + dp[j]);
      if (j > 0) {
        current[j] += (1 - prob) * (1 + current[j - 1]);
      }
    }
    copy(begin(current), end(current), begin(dp));
  }
  return dp[black];
}


int main() {
  int n, m, k;
  cin >> n >> m >> k;
  printf("%.9lf", expectedValue(n + m, k));
  return 0;
}
