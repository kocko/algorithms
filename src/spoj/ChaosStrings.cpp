#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

struct word {
    int idx;
    string s, reverse;
};

const int MAX = 200000;
hyper tree[MAX + 1];

void update(int idx) {
  for (; idx <= MAX; idx += (idx & -idx)) tree[idx]++;
}

hyper query(int idx) {
  hyper result = 0;
  for (; idx > 0; idx -= (idx & -idx)) result += tree[idx];
  return result;
}

word data[MAX];

bool lexical(const word &a, const word &b) {
  return a.s < b.s;
}

bool reverse_lexical(const word &a, const word &b) {
  return a.reverse < b.reverse;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    data[i].s = s;
    reverse(s.begin(), s.end());
    data[i].reverse = s;
  }
  sort(data, data + n, lexical);
  for (int i = 0; i < n; i++) {
    data[i].idx = i + 1;
  }
  sort(data, data + n, reverse_lexical);
  hyper result = 0;
  for (int i = 0; i < n; i++) {
    result += query(n) - query(data[i].idx);
    update(data[i].idx);
  }
  cout << result << endl;
  return 0;
}
