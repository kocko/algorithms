#include <bits/stdc++.h>

using namespace std;

typedef long long hyper;

hyper solve(hyper m, hyper n, hyper a) {
  hyper x = m / a;
  if (m % a) x++;
  hyper y = n / a;
  if (n % a) y++;
  return x * y;
}

int main(void) {
  long long n, m, a;
  cin >> n >> m >> a;
  cout << 1LL * solve(n, m, a);
  return 0;
}
