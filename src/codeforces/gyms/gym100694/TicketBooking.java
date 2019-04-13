package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TicketBooking implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    int[] student = new int[n];
    for (int i = 0; i < n; i++) {
      student[i] = in.ni();
    }
    int[] free = new int[m];
    for (int i = 0; i < m; i++) {
      free[i] = in.ni();
    }
    List<List<Integer>> result = new ArrayList<>();
    int i = 0, j = 0;
    List<Integer> current = new ArrayList<>();
    while (i < n) {
      if (student[i] == free[j]) {
        if (current.size() == k) {
          result.add(current);
          current = new ArrayList<>();
        }
        current.add(i + 1);
        i++;
        j++;
      } else {
        if (current.size() > 0) {
          result.add(current);
          current = new ArrayList<>();
        }
        j++;
      }
    }
    if (current.size() > 0) {
      result.add(current);
    }
    out.println(result.size());
    for (List<Integer> list : result) {
      out.print(list.size());
      out.print(' ');
      for (int value : list) {
        out.print(value);
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
    try (TicketBooking instance = new TicketBooking()) {
      instance.solve();
    }
  }
}
