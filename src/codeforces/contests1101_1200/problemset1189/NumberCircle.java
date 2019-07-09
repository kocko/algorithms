package codeforces.contests1101_1200.problemset1189;

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

public class NumberCircle implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.ni());
    }
    list.sort(Comparator.naturalOrder());
    int[] result = new int[n];
    result[0] = list.get(n - 1);
    result[1] = list.get(n - 2);
    result[n - 1] = list.get(n - 3);
    int left = 2, right = n - 2, next = n - 4;
    boolean front = false;
    for (int i = 2; i < n - 1; i++, next--) {
      int value = list.get(next);
      if (front) {
        result[left++] = value;
      } else {
        result[right--] = value;
      }
      front = !front;
    }
    if (!valid(result)) {
      out.println("NO");
    } else {
      out.println("YES");
      for (int num : result) {
        out.print(num);
        out.print(' ');
      }
    }
  }
  
  private boolean valid(int[] x) {
    boolean valid = true;
    int n = x.length;
    for (int i = 1; i < n - 1; i++) {
      valid &= x[i] < x[i - 1] + x[i + 1];
    }
    valid &= x[0] < x[n - 1] + x[1];
    valid &= x[n - 1] < x[0] + x[n - 2];
    return valid;
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
    try (NumberCircle instance = new NumberCircle()) {
      instance.solve();
    }
  }
}
