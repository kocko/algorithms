#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

int main(void) {
  int a[4];
  for (int i = 0; i < 4; i++) {
    cin >> a[i];
  }
  string s;
  cin >> s;
  int result = 0;

  for (int i = 0; i < s.length(); i++) {
    result += a[(int) (s[i] - '0') - 1];
  }
  cout << result << endl;
  return 0;
}
