package codeforces.contests1101_1200.problemset1154;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TwoTeams implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] skill = new int[n];
    TreeSet<Integer> neighbours = new TreeSet<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -skill[x]));
    int[] team = new int[n];
    for (int i = 0; i < n; i++) {
      skill[i] = in.ni();
      queue.add(i);
      neighbours.add(i);
      team[i] = -1;
    }
    
    int current = 0;
    while (queue.size() > 0) {
      int top = queue.poll();
      if (team[top] != -1) continue;
      neighbours.remove(top);
      team[top] = current;
      for (int i = 0; i < k; i++) {
        Integer next = neighbours.higher(top);
        if (next != null) {
          team[next] = current;
          neighbours.remove(next);
        }
      }
      for (int i = 0; i < k; i++) {
        Integer prev = neighbours.lower(top);
        if (prev != null) {
          team[prev] = current;
          neighbours.remove(prev);
        }
      }
      current ^= 1;
    }
    for (int t : team) {
      out.print(t + 1);
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (TwoTeams instance = new TwoTeams()) {
      instance.solve();
    }
  }
}
