package codeforces.contests1301_1400.problemset1374;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ZeroRemainderArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      TreeMap<Integer, ArrayDeque<Integer>> map = new TreeMap<>();
      int bad = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        int rem = next % k;
        if (rem != 0) {
          int need = k - rem;
          ArrayDeque<Integer> list = map.getOrDefault(need, new ArrayDeque<>());
          list.add(next);
          map.put(need, list);
          bad++;
        }
      }
      int x = 0;
      long result = 0;
      if (bad > 0) {
        while (bad > 0) {
          Integer nextKey = map.ceilingKey(x + 1);
          if (nextKey != null) {
            result += (nextKey - x);
            x = nextKey;
          } else {
            int firstKey = map.firstKey();
            result += (k - x + firstKey);
            x = firstKey;
          }
          ArrayDeque<Integer> queue = map.get(x);
          queue.removeFirst();
          bad--;
          if (queue.size() == 0) {
            map.remove(x);
          } else {
            map.put(x, queue);
          }
        }
        result++;
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
    try (ZeroRemainderArray instance = new ZeroRemainderArray()) {
      instance.solve();
    }
  }
}
