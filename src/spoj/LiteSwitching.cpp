#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <string>

#define endl '\n'

using namespace std;

FILE* in = stdin; FILE* out = stdout;

struct Node {
  int lo, hi, delta, off, on;

  void increment(int value) {
    delta += value;
    delta %= 2;
  }

  int getOff() {
    return (delta == 0) ? off : on;
  }

  int getOn() {
    return (delta == 0) ? on : off;
  }

  void merge(Node left, Node right) {
    off = left.getOff() + right.getOff();
    on = left.getOn() + right.getOn();
  }
};

const int MAX = 100000;

Node nodes[4 * MAX + 1];

void init(int idx, int left, int right) {
  nodes[idx].lo = left;
  nodes[idx].hi = right;
  if (left == right) {
    nodes[idx].off = 1;
  } else {
    int mid = (left + right) / 2;
    init(idx << 1, left, mid);
    init(idx << 1 | 1, mid + 1, right);
    nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
  }
}

void propagate(int idx) {
  nodes[idx << 1].increment(nodes[idx].delta);
  nodes[idx << 1 | 1].increment(nodes[idx].delta);
  nodes[idx].delta = 0;
}

void update(int idx, int left, int right) {
  if (nodes[idx].lo > right || nodes[idx].hi < left) return;
  if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
    nodes[idx].increment(1);
  } else {
    propagate(idx);
    update(idx << 1, left, right);
    update(idx << 1 | 1, left, right);
    nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
  }
}

int query(int idx, int left, int right) {
  if (nodes[idx].lo > right || nodes[idx].hi < left) return 0;
  if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
    return nodes[idx].getOn();
  }
  propagate(idx);
  int l = query(idx << 1, left, right);
  int r = query(idx << 1 | 1, left, right);
  nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
  return l + r;
}

int main() {
  int n, m;
  fscanf(in, "%d %d", &n, &m);
  init(1, 0, n - 1);
  while (m--) {
    int type, a, b;
    fscanf(in, "%d %d %d", &type, &a, &b);
    a--;
    b--;
    if (type == 0) {
      update(1, a, b);
    } else {
      int result = query(1, a, b);
      fprintf(out, "%d\n", result);
    }
  }
  return 0;
}
