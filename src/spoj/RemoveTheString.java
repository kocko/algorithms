package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.min;

public class RemoveTheString implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNext()) {
      text = in.next().toCharArray();
      pattern = in.next().toCharArray();
      automaton();
      dp = new Integer[text.length][pattern.length];
      out.println(recurse(0, 0));
    }
  }
  
  private char[] pattern, text;
  private int[][] automaton;
  
  private void automaton() {
    int n = pattern.length;
    int[] prefix = new int[n];
    int k = 0;
    for (int i = 1; i < n; i++) {
      while (k > 0 && pattern[i] != pattern[k]) {
        k = prefix[k - 1];
      }
      if (pattern[i] == pattern[k]) {
        k++;
      }
      prefix[i] = k;
    }
    automaton = new int[n + 1][26];
    for (int i = 0; i < n + 1; i++) {
      char letter = i == n ? '#' : pattern[i];
      for (char c = 'a'; c <= 'z'; c++) {
        if (i > 0 && letter != c) {
          automaton[i][c - 'a'] = automaton[prefix[i - 1]][c - 'a'];
        } else {
          automaton[i][c - 'a'] = i + (letter == c ? 1 : 0); 
        }
      }
    }
  }
  
  private Integer[][] dp;
  
  private int recurse(int idx, int current) {
    if (idx == text.length) return 0;
    
    if (dp[idx][current] != null) return dp[idx][current];
    
    int ans = 1 + recurse(idx + 1, current);
    
    int matched = automaton[current][text[idx] - 'a'];
    if (matched == pattern.length) {
      ans = min(1 + recurse(idx + 1, matched - 1), ans);
    } else {
      ans = min(ans, recurse(idx + 1, matched));
    }
    
    return dp[idx][current] = ans;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (RemoveTheString instance = new RemoveTheString()) {
      instance.solve();
    }
  }
}
