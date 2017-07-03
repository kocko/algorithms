#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

int n;
int arr[1000];

int dp[1000][1000];

int recurse(int left, int right) {
  if (left > right) return 0;

  if (dp[left][right] != -1) return dp[left][right];

  int takeLeft = 0;
  if (arr[left + 1] >= arr[right]) {
    takeLeft = arr[left] + recurse(left + 2, right);
  } else {
    takeLeft = arr[left] + recurse(left + 1, right - 1);
  }
  int takeRight = 0;
  if (arr[left] >= arr[right - 1]) {
    takeRight = arr[right] + recurse(left + 1, right - 1);
  } else {
    takeRight = arr[right] + recurse(left, right - 2);
  }

  return dp[left][right] = max(takeLeft, takeRight);
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int game = 1;
  while (cin >> n) {
    if (n == 0) break;
    fill(dp[0], dp[0] + 1000 * 1000, -1);
    int total = 0;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      total += arr[i];
    }
    int ans = recurse(0, n - 1);
    cout << "In game " << game++ << ", the greedy strategy might lose by as many as " << 2 * ans - total << " points." << endl;
  }
}
