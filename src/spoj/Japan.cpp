#include <bits/stdc++.h>

#define endl '\n'

using namespace std;

typedef long long hyper;

struct Road {
    int left, right;
};

bool compare(const Road &a, const Road &b) {
  return (a.left == b.left) ? a.right < b.right : a.left < b.left;
}

const int MAX = 1001;

hyper tree[MAX];

void update(int idx) {
  for (; idx <= MAX; idx += (idx & -idx)) tree[idx]++;
}

hyper query(int idx) {
  hyper result = 0;
  for (; idx > 0; idx -= (idx & -idx)) result += tree[idx];
  return result;
}

int main() {
  int t;
  scanf("%d", &t);
  for (int l = 1; l <= t; l++) {
    int n, m, k, a, b;
    scanf("%d%d%d", &n, &m, &k);
    Road roads[1000009];
    memset(tree, 0, sizeof tree);
    for (int i = 0; i < k; i++) {
      scanf("%d%d", &a, &b);
      roads[i].left = a;
      roads[i].right = b;
    }
    sort(roads, roads + k, compare);
    long long res = 0;
    for (int i = 0; i < k; i++) {
      res += (query(m) - query(roads[i].right));
      update(roads[i].right);
    }
    printf("Test case %d: %lld\n", l, res);
  }
  return 0;
} 
