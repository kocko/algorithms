package uva.volume004;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhatGoesUp implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    list = new ArrayList<>();
    while (in.hasNextInt()) {
      list.add(in.nextInt());
    }
    int n = list.size();
    int[] tails = new int[n];
    parent = new int[n];
    int size = 0;
    for (int i = 0; i < list.size(); i++) {
      int value = list.get(i);
      int left = 0, right = size;
      while (left != right) {
        int mid = (left + right) / 2;
        if (list.get(tails[mid]) < value) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      parent[i] = left > 0 ? tails[left - 1] : -1;
      tails[left] = i;
      if (left == size) {
        size++;
      }
    }
    out.println(size);
    out.println('-');
    print(tails[size - 1]);
  }

  private List<Integer> list;
  private int[] parent;

  private void print(int idx) {
    if (idx >= 0) {
      print(parent[idx]);
      out.println(list.get(idx));
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (WhatGoesUp instance = new WhatGoesUp()) {
      instance.solve();
    }
  }
}
