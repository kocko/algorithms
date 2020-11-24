package codeforces.contests1401_1500.problemset1454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class SequenceTransformation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int value = in.ni();
        List<Integer> list = map.getOrDefault(value, new ArrayList<>());
        list.add(i);
        map.put(value, list);
      }
      for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        entry.getValue().add(-1);
        entry.getValue().add(n);
      }
      int result = Integer.MAX_VALUE;
      for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        List<Integer> x = entry.getValue();
        x.sort(Comparator.naturalOrder());
        int score = 0;
        for (int i = 1; i < x.size(); i++) {
          if ((x.get(i) - x.get(i - 1) > 1)) {
            score++;
          }
        }
        result = Math.min(result, score);
      }
      out.println(result);
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
    try (SequenceTransformation instance = new SequenceTransformation()) {
      instance.solve();
    }
  }
}
