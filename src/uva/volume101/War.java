package uva.volume101;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class War implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        size[x] += size[y];
        root[y] = x;
      }
    }
  }

  public void solve() {
    int n = in.nextInt();
    dsu = new DisjointSet(2 * n);
    int type, a, b;
    while ((type = in.nextInt()) != 0 | (a = in.nextInt()) != 0 | (b = in.nextInt()) != 0) {
      if (type == 1) {
        setFriends(a, b);
      } else if (type == 2) {
        setEnemies(a, b);
      } else if (type == 3) {
        out.println(areFriends(a, b) ? 1 : 0);
      } else {
        out.println(areEnemies(a, b) ? 1 : 0);
      }
    }
  }

  private DisjointSet dsu;

  private void setFriends(int a, int b) {
    int u = a << 1, v = b << 1;
    if (areEnemies(a, b)) {
      out.println(-1);
    } else {
      dsu.join(u, v);
      dsu.join(u | 1, v | 1);
    }
  }

  private void setEnemies(int a, int b) {
    int u = a << 1, v = b << 1;
    if (areFriends(a, b)) {
      out.println(-1);
    } else {
      dsu.join(u, v | 1);
      dsu.join(u | 1, v);
    }
  }

  private boolean areFriends(int a, int b) {
    int u = a << 1, v = b << 1;
    return (dsu.root(u) == dsu.root(v));
  }

  private boolean areEnemies(int a, int b) {
    int u = a << 1, v = b << 1;
    return dsu.root(u) == dsu.root(v | 1);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (War instance = new War()) {
      instance.solve();
    }
  }
}
