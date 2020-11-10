package uva.volume100;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EditStepLadders implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    List<String> words = new ArrayList<>();
    while (in.hasNextLine()) {
      words.add(in.nextLine());
    }
    int n = words.size();
    Map<String, Integer> indexOf = new HashMap<>();

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = n - 1; i >= 0; i--) {
      String word = words.get(i);
      char[] x = word.toCharArray();
      for (char ch = 'a'; ch <= 'z'; ch++) {
        for (int idx = 0; idx < x.length; idx++) {
          char old = x[idx];
          x[idx] = ch;
          String temp = new String(x);
          if (indexOf.containsKey(temp)) {
            int j = indexOf.get(temp);
            if (i != j) {
              graph.get(i).add(j);
            }
          }
          x[idx] = old;
        }
      }
      for (int split = 0; split <= word.length(); split++) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          String temp = word.substring(0, split) + ch + word.substring(split);
          if (indexOf.containsKey(temp)) {
            int j = indexOf.get(temp);
            if (i != j) {
              graph.get(i).add(j);
            }
          }
        }
      }
      for (int skip = 0; skip < word.length(); skip++) {
        String temp = word.substring(0, skip) + word.substring(skip + 1);
        if (indexOf.containsKey(temp)) {
          int j = indexOf.get(temp);
          if (i != j) {
            graph.get(i).add(j);
          }
        }
      }
      indexOf.put(word, i);
    }
    int[] dp = new int[n];
    int max = 0;
    for (int idx = n - 1; idx >= 0; idx--) {
      int mx = 0;
      for (int v : graph.get(idx)) {
        mx = Math.max(dp[v], mx);
      }
      dp[idx] = 1 + mx;
      max = Math.max(dp[idx], max);
    }
    out.println(max);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (EditStepLadders instance = new EditStepLadders()) {
      instance.solve();
    }
  }
}
