package atcoder.beginner.contest188;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCTournament implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    List<int[]> list = new ArrayList<>();
    for (int i = 1; i <= (1 << n); i++) {
      list.add(new int[]{i, in.ni()});
    }
    while (list.size() > 2) {
      List<int[]> next = new ArrayList<>();
      for (int i = 0; i < list.size(); i += 2) {
        int[] a = list.get(i), b = list.get(i + 1);
        if (a[1] > b[1]) {
          next.add(a);
        } else {
          next.add(b);
        }
      }
      list = next;
    }
    int result;
    if (list.get(0)[1] > list.get(1)[1]) {
      result = list.get(1)[0];
    } else {
      result = list.get(0)[0];
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
    try (ABCTournament instance = new ABCTournament()) {
      instance.solve();
    }
  }
}
