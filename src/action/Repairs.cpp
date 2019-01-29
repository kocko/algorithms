#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <string>
#include <queue>

using namespace std;

FILE* in = stdin; FILE* out = stdout;

const int MAX_N = 20000, oo = (int) 1e9;

struct Edge {
  int from, to, weight;
};

bool operator<(const Edge& left, const Edge& right) {
  return left.weight > right.weight;
}

int n, m;
int root[MAX_N + 1];
int sz[MAX_N + 1];

void init() {
  for (int i = 0; i < n; i++) {
    root[i] = i;
    sz[i] = 1;
  }
}

int parent(int x) {
  return x == root[x] ? x : (root[x] = parent(root[x]));
}

bool join(int a, int b) {
  int x = parent(a), y = parent(b);
  if (x != y) {
    if (sz[x] < sz[y]) y = x ^ y ^ (x = y);
    sz[x] += sz[y];
    root[y] = x;
    return true;
  }
  return false;
}


int main() {
  fscanf(in, "%d %d", &n, &m);
  init();

  priority_queue<Edge> queue;

  for (int i = 0; i < m; i++) {
    int u, v, w;
    fscanf(in, "%d %d %d", &u, &v, &w);
    Edge a;
    a.from = u - 1;
    a.to = v - 1;
    a.weight = w;
    queue.push(a);
  }

  long long total = 0;
  while (queue.size() > 0) {
    Edge top = queue.top();
    queue.pop();
    if (!join(top.from, top.to)) {
      total += top.weight;
    }
  }

  int p = parent(0);
  bool connected = true;
  for (int i = 0; i < n; i++) {
    connected &= parent(i) == p;
  }

  fprintf(out, "%lld", (connected ? total : -1));
  return 0;
}
