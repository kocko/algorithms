#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

int cnt[3];

int main(void) {
  int n;
  cin >> n;
  int next, max = 0, result = 0;
  for (int i = 0; i < n; i++) {
    cin >> next;
    cnt[i % 3] += next;
    if (cnt[i % 3] > max) {
      max = cnt[i % 3];
      result = i % 3;
    }
  }
  if (result == 0) {
    cout << "chest" << endl;
  } else if (result == 1) {
    cout << "biceps" << endl;
  } else {
    cout << "back" << endl;
  }
}
