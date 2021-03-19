package templates;

public class FenwickTree {
  private int MAX;
  private int[] tree;

  private FenwickTree(int n) {
    MAX = n;
    tree = new int[MAX + 1];
  }

  private void update(int idx, int delta) {
    for (; idx <= MAX; idx += (idx & -idx)) {
      tree[idx] += delta;
    }
  }

  private int query(int idx) {
    int result = 0;
    for (; idx > 0; idx -= (idx & -idx)) {
      result += tree[idx];
    }
    return result;
  }
}
