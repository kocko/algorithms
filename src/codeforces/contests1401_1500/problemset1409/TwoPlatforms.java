package codeforces.contests1401_1500.problemset1409;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TwoPlatforms implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      TreeMap<Integer, Integer> count = new TreeMap<>();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        y[i] = in.ni();
        count.put(x[i], count.getOrDefault(x[i], 0) + 1);
      }
      int[] prefix = new int[count.size() + 1];
      Iterator<Integer> iterator = count.keySet().iterator();
      Map<Integer, Integer> indexOf = new HashMap<>();
      for (int i = 1; i < prefix.length; i++) {
        int key = iterator.next();
        prefix[i] = prefix[i - 1] + count.get(key);
        indexOf.put(key, i);
      }

      Map<Integer, Integer> start = new HashMap<>();
      for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        int startsAt = entry.getKey();
        int endsAt = count.floorKey(startsAt + k);
        int i = indexOf.get(startsAt);
        int j = indexOf.get(endsAt);
        start.put(startsAt, prefix[j] - prefix[i - 1]);
      }

      Map<Integer, Integer> end = new HashMap<>();
      for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
        int endsAt = entry.getKey();
        int startsAt = count.ceilingKey(Math.max(endsAt - k, 1));
        int i = indexOf.get(startsAt);
        int j = indexOf.get(endsAt);
        end.put(endsAt, prefix[j] - prefix[i - 1]);
      }

      int[] maxEndingHere = new int[count.size() + 1];
      iterator = count.keySet().iterator();
      for (int i = 1; i < prefix.length; i++) {
        int key = iterator.next();
        maxEndingHere[i] = Math.max(maxEndingHere[i - 1], end.get(key));
      }

      int result = 0;
      for (Map.Entry<Integer, Integer> entry : start.entrySet()) {
        int here = entry.getValue();
        int startsAt = entry.getKey();

        Integer leftEnd = count.floorKey(startsAt - 1);
        if (leftEnd != null) {
          here += maxEndingHere[indexOf.get(leftEnd)];
        }

        if (here > result) {
          result = here;
        }
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
    try (TwoPlatforms instance = new TwoPlatforms()) {
      instance.solve();
    }
  }
}
