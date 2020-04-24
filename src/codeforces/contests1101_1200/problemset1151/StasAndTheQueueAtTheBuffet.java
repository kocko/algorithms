package codeforces.contests1101_1200.problemset1151;

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

public class StasAndTheQueueAtTheBuffet implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    class Person implements Comparable<Person> {
      private long a, b;

      private Person(long a, long b) {
        this.a = a;
        this.b = b;
      }

      @Override
      public int compareTo(Person person) {
        return Long.compare(person.a - person.b, a - b);
      }
    }
    int n = in.ni();
    List<Person> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Person(in.nl(), in.nl()));
    }
    list.sort(Comparator.naturalOrder());
    long result = 0;
    for (int i = 0; i < n; i++) {
      Person p = list.get(i);
      result += p.a * i + p.b * (n - i - 1);
    }
    out.println(result);
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
    try (StasAndTheQueueAtTheBuffet instance = new StasAndTheQueueAtTheBuffet()) {
      instance.solve();
    }
  }
}
