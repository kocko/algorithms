package templates;

public class DisjointSet {

  private int[] root, size;

  public DisjointSet(int n) {
    root = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
      size[i] = 1;
    }
  }

  private int root(int x) {
    return (x == root[x]) ? x : (root[x] = root(root[x]));
  }

  private void join(int a, int b) {
    int x = root(a), y = root(b);
    if (x != y) {
      if (size[x] < size[y]) {
        int t = x;
        x = y;
        y = t;
      }
      size[x] += size[y];
      root[y] = x;
    }
  }

}
