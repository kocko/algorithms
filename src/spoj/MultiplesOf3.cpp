#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <string>

#define endl '\n'

using namespace std;

FILE* in = stdin; FILE* out = stdout;

struct Node {
  int lo, hi, delta, zero, one, two;

  void add(int value) {
    delta += value;
    delta %= 3;
  }

  int getZero() {
    return (delta == 0) ? zero : (delta == 1 ? two : one);
  }

  int getOne() {
    return (delta == 0) ? one : (delta == 1 ? zero : two);
  }

  int getTwo() {
    return (delta == 0) ? two : (delta == 1 ? one : zero);
  }

  void merge(Node left, Node right) {
    zero = left.getZero() + right.getZero();
    one = left.getOne() + right.getOne();
    two = left.getTwo() + right.getTwo();
  }
};

const int MAX = 100000;

Node nodes[4 * MAX + 1];

void init(int idx, int left, int right) {
  nodes[idx].lo = left;
  nodes[idx].hi = right;
  if (left == right) {
    nodes[idx].zero = 1;
  } else {
    int mid = (left + right) / 2;
    init(idx << 1, left, mid);
    init(idx << 1 | 1, mid + 1, right);
    nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
  }
}

void propagate(int idx) {
  nodes[idx << 1].add(nodes[idx].delta);
  nodes[idx << 1 | 1].add(nodes[idx].delta);
  nodes[idx].delta = 0;
}

void update(int idx, int left, int right) {
  if (nodes[idx].lo > right || nodes[idx].hi < left) return;
  if (nodes[idx].lo >= left && nodes[idx].hi <= right) {
    nodes[idx].add(1);
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
    return nodes[idx].getZero();
  }
  propagate(idx);
  int l = query(idx << 1, left, right);
  int r = query(idx << 1 | 1, left, right);
  nodes[idx].merge(nodes[idx << 1], nodes[idx << 1 | 1]);
  return l + r;
}

int main() {
  int n, q;
  fscanf(in, "%d %d", &n, &q);
  init(1, 0, n - 1);
  while (q--) {
    int type, a, b;
    fscanf(in, "%d %d %d", &type, &a, &b);
    if (type == 0) {
      update(1, a, b);
    } else {
      int result = query(1, a, b);
      fprintf(out, "%d\n", result);
    }
  }
  return 0;
}
