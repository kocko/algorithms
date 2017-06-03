#include <bits/stdc++.h>

#define endl '\n'

using namespace std;
typedef long long hyper;

const int MAX = 300000;
int tree[MAX + 1];
int lastSeen[1000001];
int ans[200001];

void update(int idx, int delta) {
  for (; idx <= MAX; idx += (idx & -idx)) {
    tree[idx] += delta;
  }
}

int f(int idx) {
  int result = 0;
  for (; idx > 0; idx -= (idx & -idx)) {
    result += tree[idx];
  }
  return result;
}

int query(int left, int right) {
  return f(right) - f(left - 1);
}

struct Query {
    int idx, left, right, answer;
    Query(int idx, int left, int right): idx(idx), left(left), right(right), answer(0) {}

    bool operator < (const Query& query) const {
      return right < query.right;
    }
};

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n;
  cin >> n;
  int arr[n + 1];
  memset(arr, 0, sizeof(arr));
  for (int i = 1; i <= n; i++) {
    cin >> arr[i];
  }

  int q;
  cin >> q;
  vector<Query> queries;
  for (int i = 0; i < q; i++) {
    int left, right;
    cin >> left >> right;
    queries.push_back(Query(i, left, right));
  }
  sort(queries.begin(), queries.end());
  int idx = 0;
  for (int i = 1; i <= n; ++i) {
    if (idx == queries.size()) break;

    int value = arr[i];
    if (lastSeen[value] != 0) {
      update(lastSeen[value], -1);
    }
    lastSeen[value] = i;
    update(i, 1);
    while (idx < queries.size() && queries[idx].right == i) {
      Query& q = queries[idx];
      ans[q.idx] = query(q.left, q.right);
      idx++;
    }
  }
  for (int i = 0; i < q; i++) {
    cout << ans[i] << endl;
  }
}

