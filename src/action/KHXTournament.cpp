#include <bits/stdc++.h>

using namespace std;

#define endl '\n'

typedef long long hyper;

const int MAXN = 100, MAXK = 20;

const int points[3][3] = { {0, 1, -1}, {-1, 0, 1}, {1, -1, 0}};

int n, k;
hyper result;
int strategies[MAXN][MAXK];
int mask[MAXK];
map<string, hyper> half;

int calculate(int idx, int start, int end) {
  int result = 0;
  for (int i = start, j = 0; i < end; i++, j++) {
    result += points[strategies[idx][i]][mask[j]];
  }
  return result;
}

void left(int idx) {
  if (idx == k / 2) {
    string key = "";
    for (int i = 0; i < n; i++) {
      int p = calculate(i, 0, k / 2);
      key += ('A' + p);
    }
    half[key]++;
  } else {
    mask[idx] = 0; left (idx + 1);
    mask[idx] = 1; left (idx + 1);
    mask[idx] = 2; left (idx + 1);
  }
}

void right(int idx) {
  if (idx == k - (k / 2)) {
    string key = "";
    for (int i = 0; i < n; i++) {
      int p = calculate(i, k / 2, k);
      key += ('A' - p);
    }
    if (half.find(key) != half.end()) {
      result += half[key];
    }
  } else {
    mask[idx] = 0; right(idx + 1);
    mask[idx] = 1; right(idx + 1);
    mask[idx] = 2; right(idx + 1);
  }
}

int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    char temp[25];
    cin >> temp;
    for (int j = 0; j < k; j++) {
      char ch = temp[j];
      strategies[i][j] = ch == 'K' ? 0 : (ch == 'H' ? 1 : 2); 
    }
  }
  if (k == 1) {
    bool allSame = true;
    for (int i = 1; i < n; i++) {
      allSame &= (strategies[i][0] == strategies[0][0]);
    }
    if (allSame) result = 1;
  } else {
    left(0);
    right(0);
  }
  cout << result << endl;
  return 0;
}