package codeforces.gyms.gym102591;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Pairing implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    class Person {
      private int idx;
      private long strength;

      private Person(int idx, long strength) {
        this.idx = idx;
        this.strength = strength;
      }
    }
    int n = in.ni();
    List<Person> list = new ArrayList<>();
    list.add(new Person(0, 0));
    for (int i = 1; i <= n; i++) {
      list.add(new Person(i, in.nl()));
    }
    list.sort(Comparator.comparingLong(p -> p.strength));

    long[] odd = new long[n + 1], even = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      long s = list.get(i).strength;
      if (i % 2 == 0) {
        even[i] = even[i - 2] + s;
        odd[i] = odd[i - 1];
      } else {
        odd[i] = s;
        if (i > 1) {
          odd[i] += odd[i - 2];
        }
        even[i] = even[i - 1];
      }
    }
    long[] result = new long[n];
    for (int i = 1; i <= n; i++) {
      int idx = list.get(i).idx;
      long ans;
      if (i % 2 == 0) {
        ans = odd[i] + even[n] - even[i];
      } else {
        ans = odd[i - 1] + even[n] - even[i];
      }
      result[idx - 1] = ans;
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (Pairing instance = new Pairing()) {
      instance.solve();
    }
  }
}
