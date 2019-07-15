package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Encoding implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    String number = in.next();
    Set<String> seen = new HashSet<>();
    String min = number;
    seen.add(number);
    while (number.length() % 2 == 0) {
      String previous = getPrevious(number);
      if (previous == null || !encode(previous).equals(number) || !seen.add(previous)) {
        break;
      }
      if (better(previous, min)) {
        min = previous;
      }
      number = previous;
    }
    out.println(min);
  }

  private String encode(String x) {
    StringBuilder result = new StringBuilder();
    char current = x.charAt(0);
    int count = 1;
    for (int i = 1; i < x.length(); i++) {
      if (x.charAt(i) == current) {
        count++;
      } else {
        result.append(count);
        result.append(current);
        current = x.charAt(i);
        count = 1;
      }
    }
    result.append(count);
    result.append(current);
    return result.toString();
  }

  private boolean better(String a, String b) {
    if (a.length() < b.length()) return true;
    return a.length() == b.length() && b.compareTo(a) > 0;
  }

  private String getPrevious(String number) {
    if (number.length() % 2 == 1) return number;
    StringBuilder result = new StringBuilder();
    int n = number.length();
    for (int i = 0; i < n; i += 2) {
      int count = number.charAt(i) - '0', digit = number.charAt(i + 1) - '0';
      for (int j = 0; j < count; j++) {
        result.append(digit);
      }
    }
    String ans = result.toString();

    return valid(ans) ? ans : null;
  }

  private boolean valid(String x) {
    if ("0".equals(x)) return true;
    int current = 0, max = 0;
    char ch = '-';
    for (int i = 0; i < x.length(); i++) {
      if (x.charAt(i) == ch) {
        current++;
      } else {
        max = Math.max(current, max);
        current = 1;
        ch = x.charAt(i);
      }
    }
    max = Math.max(current, max);
    return x.charAt(0) != '0' && max <= 9;
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
    try (Encoding instance = new Encoding()) {
      instance.solve();
    }
  }
}
