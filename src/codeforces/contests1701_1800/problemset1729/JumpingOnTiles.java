package codeforces.contests1701_1800.problemset1729;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class JumpingOnTiles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      Map<Character, List<Integer>> map = new HashMap<>();
      int n = x.length;
      for (int i = 0; i < n; i++) {
        List<Integer> indices = map.getOrDefault(x[i], new ArrayList<>());
        indices.add(i + 1);
        map.put(x[i], indices);
      }
      List<Integer> result = new ArrayList<>();
      int step = x[0] >= x[n - 1] ? -1 : 1;
      char prev = x[0];
      int cost = 0;
      for (char c = x[0]; c != x[n - 1]; c += step) {
        if (map.containsKey(c)) {
          result.addAll(map.get(c));
          cost += Math.abs(c - prev);
          prev = c;
        }
      }
      result.addAll(map.get(x[n - 1]));
      cost += Math.abs(prev - x[n - 1]);
      out.println(cost + " " + result.size());
      for (int idx : result) {
        out.print(idx);
        out.print(' ');
      }
      out.println();
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
    try (JumpingOnTiles instance = new JumpingOnTiles()) {
      instance.solve();
    }
  }
}